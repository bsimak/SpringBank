package org.example.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.context.ApplicationConfiguration;
import org.example.model.Transaction;
import org.example.service.TransactionService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MyBankServlet extends HttpServlet {

    private TransactionService transactionService;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        // is only needed that @PreDestroy works properly with IDE
        ctx.registerShutdownHook();

        this.objectMapper = ctx.getBean(ObjectMapper.class);
        this.transactionService = ctx.getBean(TransactionService.class);

        System.out.println("im servlet - init");
    }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if (request.getRequestURI().equalsIgnoreCase("/transactions")) {

            System.out.println("MyBankServlet doPost");
            Integer amount = Integer.valueOf(request.getParameter("amount"));
            String reference = request.getParameter("reference");

            Transaction transaction = transactionService.create(amount,reference);

            response.setContentType("application/json; charset=UTF-8");
            String json = new ObjectMapper().writeValueAsString(transaction);
            System.out.println(json);
            response.getWriter().print(json);
        }
        else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    "<html>\n" +
                            "<body>\n" +
                            "<h1>Hello Barbara</h1>\n" +
                            "<p>This will be your bank application</p>\n" +
                            "</body>\n" +
                            "</html>\n");
        }
        else if (request.getRequestURI().equalsIgnoreCase("/transactions"))
        {
            System.out.println("MyBankServlet doGet");

            response.setContentType("application/json; charset=UTF-8");
            List<Transaction> transactions = transactionService.findAll();
            response.getWriter().print(objectMapper.writeValueAsString(transactions));
            System.out.println(objectMapper.writeValueAsString(transactions));
        }
    }
}
