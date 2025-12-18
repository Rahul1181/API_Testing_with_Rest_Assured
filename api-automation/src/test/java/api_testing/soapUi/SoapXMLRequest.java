package api_testing.soapUi;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//We are sending a SOAP XMLrequest from a file to a SOAP service and validating the HTTP response 
public class SoapXMLRequest {

    @Test
    public void validateSoapXML(){
        //Tell REST Assured where the SOAP service lives
        baseURI="http://www.dneonline.com/";

        //Point to the SOAP XML file
        File soapFile =new File("src/test/java/api_testing/config/soapAdd.xml");

        //Now check if file exist or not
        if(!soapFile.exists()){
            System.out.println(">> File is not available");
            return;
        }
        System.out.println(">> File is available");

        //Read the XML file into a String
        String soapRequestBody;
        try(FileInputStream fileInputStream = new FileInputStream(soapFile)){
            // IOUtils is coming from commons Apache dependency
            soapRequestBody = IOUtils.toString(fileInputStream, "UTF-8");
        }catch(IOException e){
            e.printStackTrace();
            return;
        }

        
        //Send the SOAP request
        given()
            .contentType("text/xml")
            .accept(ContentType.XML)
            .body(soapRequestBody)
        .when()
            .post("calculator.asmx")
        .then()
            .statusCode(200);
    }
}
