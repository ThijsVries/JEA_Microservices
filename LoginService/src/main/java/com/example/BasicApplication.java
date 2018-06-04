package com.example;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@SpringBootApplication
public class BasicApplication {

    @RequestMapping(value = "find/{title}", method = RequestMethod.GET)
    public BookComplete findBook(@PathVariable("title") String titel) throws JSONException {
        //Ask next service to find book 
        DefaultHttpClient client = new DefaultHttpClient();

        Book book = null;
        BookReview review = null;
        BookProduct product = null;

        HttpHost target = new HttpHost("localhost", 8080, "http");
        HttpGet getRequest = new HttpGet("/books/" + titel);

        //Get the book data from the library service
        try {
            HttpResponse httpResponse = client.execute(target, getRequest);
            HttpEntity entity = httpResponse.getEntity();

            if (entity != null) {

                Gson gson = new Gson();

                book = gson.fromJson(GetJsonFromEntity(entity).toString(), Book.class);
                System.out.println(book.getId());

                //There is a book, so get the extra info
                HttpHost targetReview = new HttpHost("localhost", 8060, "http");
                HttpGet getRequestReview = new HttpGet("/bookreviews/" + book.getId());

                HttpResponse httpResponseReview = client.execute(targetReview, getRequestReview);
                HttpEntity entityReview = httpResponseReview.getEntity();
                
                review = gson.fromJson(GetJsonFromEntity(entityReview).toString(), BookReview.class);
                
                HttpHost targetProduct = new HttpHost("localhost", 8070, "http");
                HttpGet getRequestProduct = new HttpGet("/bookproducts/" + book.getId());
                
                HttpResponse httpResponseProduct = client.execute(targetProduct, getRequestProduct);
                HttpEntity entityProduct = httpResponseProduct.getEntity();
                
                product = gson.fromJson(GetJsonFromEntity(entityProduct).toString(), BookProduct.class);
                
                

            }
        } catch (IOException ex) {
            Logger.getLogger(BasicApplication.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return new BookComplete(book, product, review);
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    private JSONObject GetJsonFromEntity(HttpEntity entity) {
        try {
            String retSrc = EntityUtils.toString(entity);
            JSONObject result = new JSONObject(retSrc);
            return result;
        } catch (IOException ex) {
            Logger.getLogger(BasicApplication.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(BasicApplication.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (JSONException ex) {
            Logger.getLogger(BasicApplication.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
