package com.gft.pricingapp.exception

import jakarta.persistence.EntityNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import spock.lang.Specification
import spock.lang.Subject

class GlobalExceptionHandlerTest extends Specification {

    @Subject
    GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler()

    def "handleEntityNotFound should return NOT_FOUND status and message"() {
        given:
        def exception = new EntityNotFoundException("Entity not found")

        when:
        def response = globalExceptionHandler.handleEntityNotFound(exception)

        then:
        response == [message: "Entity not found"]
    }

    def "handleValidationExceptions should return BAD_REQUEST status and validation errors"() {
        given:
        def fieldError = new FieldError("objectName", "fieldName", "error message")
        def bindingResult = Mock(BindingResult)
        bindingResult.getAllErrors() >> [fieldError]
        def exception = new MethodArgumentNotValidException(null, bindingResult)

        when:
        ResponseEntity<Map<String, String>> response = globalExceptionHandler.handleValidationExceptions(exception)

        then:
        response.statusCode.value() == 400
        response.body == [fieldName: "error message"]
    }
}