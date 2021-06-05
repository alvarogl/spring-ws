//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.06.04 a las 11:53:15 PM CEST 
//


package com.alvaro.soap.employeemanagement.service.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GetEmployeeResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetEmployeeResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EmployeeDetails" type="{http://localhost/hrms}EmployeeDetails"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEmployeeResponse", propOrder = {
    "employeeDetails"
})
public class GetEmployeeResponse {

    @XmlElement(name = "EmployeeDetails", required = true)
    protected EmployeeDetails employeeDetails;

    /**
     * Obtiene el valor de la propiedad employeeDetails.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeDetails }
     *     
     */
    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    /**
     * Define el valor de la propiedad employeeDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeDetails }
     *     
     */
    public void setEmployeeDetails(EmployeeDetails value) {
        this.employeeDetails = value;
    }

}
