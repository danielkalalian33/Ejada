package com.example.ejada.services;

import com.example.ejada.models.Request;
import com.example.ejada.models.Response;
import com.example.ejada.models.Statistics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestService {
    List<Request> requests = new ArrayList<>();
    List<Response> responses = new ArrayList<>();

    public String handleDifferentRequests(Request request) {
        String responseStatus;

        Response response = new Response();
        response.setId(request.getId());
        response.setFunc(request.getFunc());

        switch (request.getFunc()) {
            case "Func1":
                response.setStatus("OK");
                responseStatus = func1(request);
                break;
            case "Func2":
                response.setStatus("OK");
                responseStatus = func2(request);
                break;
            case "Func3":
                response.setStatus("OK");
                responseStatus = func3(request);
                break;
            default:
                response.setStatus("FAILED");
                responseStatus = response.getStatus();
        }
        requests.add(request);
        responses.add(response);

        return responseStatus;
    }

    public Statistics applicationStatistics() {
        Statistics statistics = new Statistics();
        statistics.setFunc1Count((int) requests.stream().filter(r -> r.getFunc().equals("Func1")).count());
        statistics.setFunc2Count((int) requests.stream().filter(r -> r.getFunc().equals("Func2")).count());
        statistics.setFunc3Count((int) requests.stream().filter(r -> r.getFunc().equals("Func3")).count());
        statistics.setNumberOfIssues((int) responses.stream().filter(r -> r.getStatus().equals("FAILED")).count());

        return statistics;
    }

    String func1(Request request) {
        System.out.println("Func1");
        return responses.get(request.getId()).getStatus();
    }

    String func2(Request request) {
        System.out.println("Func2");
        return responses.get(request.getId()).getStatus();
    }

    String func3(Request request) {
        System.out.println("Func3");
        return responses.get(request.getId()).getStatus();
    }
}
