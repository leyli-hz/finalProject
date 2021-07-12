package com.me.controller.save;

import com.me.model.confige.UploaderUtils;
import com.me.model.entity.Email;
import com.me.model.entity.Employee;
import com.me.model.service.EmailService;
import com.me.model.service.EmployeeService;
import javazoom.upload.MultipartFormDataRequest;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/email/save.do")
@MultipartConfig
public class EmailSave extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      /* String[] receiverEmployees = UploaderUtils.mrequest.getParameterValues("receiverEmployee");
        for (String employeeId : receiverEmployees) {
            System.out.println(employeeId);
        }*/
           Email email = new Email();
           try {
            UploaderUtils uploader = new UploaderUtils(req, "uploadFile", "C:\\ROOT\\UPLOAD", 10000000l, false);
            uploader.save();
            System.out.println("C:\\ROOT\\UPLOAD\\" + uploader.getFileName());
            email.setFileAddress("C:\\ROOT\\UPLOAD\\" + uploader.getFileName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("FileAddress ham set shod!");
        email.setDateTime(new Timestamp(System.currentTimeMillis()));

        email.setSubject(UploaderUtils.mrequest.getParameter("subject"));
        System.out.println("subject :  " + UploaderUtils.mrequest.getParameter("subject"));
        email.setContent(UploaderUtils.mrequest.getParameter("subject"));
        System.out.println("content :  " + UploaderUtils.mrequest.getParameter("content"));
        System.out.println("date , subject , content  set shod!");

        Employee senderOfEmailID = getSenderOfEmail(UploaderUtils.mrequest);
        System.out.println(senderOfEmailID.toString());
        email.setSenderID(senderOfEmailID);
        System.out.println("senderId : " + UploaderUtils.mrequest.getParameter("senderId"));
        System.out.println("senderId set shod !");

        String[] s = UploaderUtils.mrequest.getParameterValues("receiverEmployee");
        Set<Employee> receivers = new HashSet<>();
        for (int i = 0; i <s.length ; i++) {
           // System.out.println(s[i]);
            Employee employee = EmployeeService.getInstance().findOne(Integer.parseInt(s[i]));
            receivers.add(employee);
        }
        for (Employee receiver : receivers) {
            System.out.println(receiver.toString());
        }
        email.setReceiversID(receivers);
        System.out.println("receivers are setted.");
        try {
            EmailService.getInstance().save(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("save shod ");
        //  req.getRequestDispatcher("").forward(req,resp);
    }

    public Employee getSenderOfEmail(MultipartFormDataRequest request) {

        System.out.println("sender id : " + request.getParameter("senderId"));
        int senderId = Integer.parseInt(request.getParameter("senderId"));
        Employee employee = EmployeeService.getInstance().findOne(senderId);
        return employee;
    }


}
