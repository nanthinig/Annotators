package com.company.resources;

import com.company.api.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

@Path("/")

public class Resource {
    @GET
    @Path("/hello")
    public String hello() {
        return "hello";

    }

    @GET
    @Path("/query")
    public String query(@QueryParam("message") String message) {
        return "You passes" + message;
    }

    @POST
    @Path("/postbody")
    public String postBody(String message) {
        return "You Posted" + message;
    }

    @POST
    @Path("/postparam")
    public String postParam(@FormParam("message") String message) {
        return "You posted" + message;
    }

    private static final String FILE_PATH = "/home/auxouser/Pictures/img1.png";

    @GET
    @Path("/image")
    @Produces("image/png")
    public Response getFile() {
        File file = new File(FILE_PATH);
        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "filename=\"myimg.png\"");
        return response.build();
    }

    public static final String F_P = "/home/auxouser/Nandhu/correctrun.txt";

    @GET
    @Path("/text")
    @Produces("plain/text")
    public Response getFile1() {
        File f1 = new File(F_P);
        Response.ResponseBuilder response = Response.ok((Object) f1);
        response.header("Content-Disposition", "filename=\"myfile.txt\"");
        return response.build();
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?>" + "<hello>Hello api" + "</hello>";

    }

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public String sayHTMLHello() {
        return "<html> " + "<title>" + "Hello Jersey" + "</title>"
                + "<body><h1 color=yellow>" + "Hello Jersey HTML" + "</h1></body>" + "</html> ";
    }

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }

    @Path("consumesboth")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void getBothRequest(Student s)
    {
        System.out.println("#########Student details@@@@@@@@@");
        System.out.println("Student name:" + s.getName());
        System.out.println("Student Age:" + s.getAge());
    }
}