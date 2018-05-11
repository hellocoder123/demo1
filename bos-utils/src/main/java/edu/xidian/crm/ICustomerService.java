
package edu.xidian.crm;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ICustomerService", targetNamespace = "http://service.crm.xidian.edu/")
@XmlSeeAlso({
})
public interface ICustomerService {


    /**
     * 
     * @param arg0
     * @return
     *     returns edu.xidian.crm.Customer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findCustomerByTelephone", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.FindCustomerByTelephone")
    @ResponseWrapper(localName = "findCustomerByTelephoneResponse", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.FindCustomerByTelephoneResponse")
    public Customer findCustomerByTelephone(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "assigncustomerstodecidedzone", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.Assigncustomerstodecidedzone")
    @ResponseWrapper(localName = "assigncustomerstodecidedzoneResponse", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.AssigncustomerstodecidedzoneResponse")
    public void assigncustomerstodecidedzone(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        List<Integer> arg1);

    /**
     * 
     * @return
     *     returns java.util.List<edu.xidian.crm.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findListNotAssociation", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.FindListNotAssociation")
    @ResponseWrapper(localName = "findListNotAssociationResponse", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.FindListNotAssociationResponse")
    public List<Customer> findListNotAssociation();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findDecidedzoneIdByAddress", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.FindDecidedzoneIdByAddress")
    @ResponseWrapper(localName = "findDecidedzoneIdByAddressResponse", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.FindDecidedzoneIdByAddressResponse")
    public String findDecidedzoneIdByAddress(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<edu.xidian.crm.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findListHasAssociation", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.FindListHasAssociation")
    @ResponseWrapper(localName = "findListHasAssociationResponse", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.FindListHasAssociationResponse")
    public List<Customer> findListHasAssociation(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<edu.xidian.crm.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://service.crm.xidian.edu/", className = "edu.xidian.crm.FindAllResponse")
    public List<Customer> findAll();

}
