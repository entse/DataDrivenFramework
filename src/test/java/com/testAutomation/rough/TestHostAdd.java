package com.testAutomation.rough;

import com.testAutomation.utilities.MonitoringMail;
import com.testAutomation.utilities.TestConfig;

import javax.mail.MessagingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestHostAdd {

    public static void main(String[] args) throws UnknownHostException, MessagingException {

        MonitoringMail mail = new MonitoringMail();
        String messageBody = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/job/DataDrivenLiveProject/Extent_20Reports/";
        System.out.println(messageBody);

        mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
    }
}
