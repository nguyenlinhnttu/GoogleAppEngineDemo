package com.example.LynkMieu.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Nullable;
import javax.inject.Named;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * WARNING: This generated code is intended as a sample or starting point for using a
 * Google Cloud Endpoints RESTful API with an Objectify entity. It provides no data access
 * restrictions and no data validation.
 * <p>
 * DO NOT deploy this code unchanged as part of a real application to real users.
 */
@Api(
        name = "employeeApi",
        version = "v1",
        resource = "employee",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.LynkMieu.example.com",
                ownerName = "backend.myapplication.LynkMieu.example.com",
                packagePath = ""
        )
)
public class EmployeeEndpoint {

    private static final Logger logger = Logger.getLogger(EmployeeEndpoint.class.getName());

    private static final int DEFAULT_LIST_LIMIT = 20;

    static {
        // Typically you would register this inside an OfyServive wrapper. See: https://code.google.com/p/objectify-appengine/wiki/BestPractices
        ObjectifyService.register(Employee.class);
    }

    /**
     * Returns the {@link Employee} with the corresponding ID.
     *
     * @param id the ID of the entity to be retrieved
     * @return the entity with the corresponding ID
     * @throws NotFoundException if there is no {@code Employee} with the provided ID.
     */
    @ApiMethod(
            name = "get",
            path = "employee/{id}",
            httpMethod = ApiMethod.HttpMethod.GET)
    public Employee get(@Named("id") Long id) throws NotFoundException {
        logger.info("Getting Employee with ID: " + id);
        Employee employee = ofy().load().type(Employee.class).id(id).now();
        if (employee == null) {
            throw new NotFoundException("Could not find Employee with ID: " + id);
        }
        return employee;
    }

    /**
     * Inserts a new {@code Employee}.
     */
    @ApiMethod(
            name = "insert",
            path = "employee",
            httpMethod = ApiMethod.HttpMethod.POST)
    public Employee insert(Employee employee) {
        // Typically in a RESTful API a POST does not have a known ID (assuming the ID is used in the resource path).
        // You should validate that employee.id has not been set. If the ID type is not supported by the
        // Objectify ID generator, e.g. long or String, then you should generate the unique ID yourself prior to saving.
        //
        // If your client provides the ID then you should probably use PUT instead.
        ofy().save().entity(employee).now();
        logger.info("Created Employee with ID: " + employee.getId());

        return ofy().load().entity(employee).now();
    }

    /**
     * Updates an existing {@code Employee}.
     *
     * @param id       the ID of the entity to be updated
     * @param employee the desired state of the entity
     * @return the updated version of the entity
     * @throws NotFoundException if the {@code id} does not correspond to an existing
     *                           {@code Employee}
     */
    @ApiMethod(
            name = "update",
            path = "employee/{id}",
            httpMethod = ApiMethod.HttpMethod.PUT)
    public Employee update(@Named("id") Long id, Employee employee) throws NotFoundException {
        // TODO: You should validate your ID parameter against your resource's ID here.
        checkExists(id);
        ofy().save().entity(employee).now();
        logger.info("Updated Employee: " + employee);
        return ofy().load().entity(employee).now();
    }

    /**
     * Deletes the specified {@code Employee}.
     *
     * @param id the ID of the entity to delete
     * @throws NotFoundException if the {@code id} does not correspond to an existing
     *                           {@code Employee}
     */
    @ApiMethod(
            name = "remove",
            path = "employee/{id}",
            httpMethod = ApiMethod.HttpMethod.DELETE)
    public void remove(@Named("id") Long id) throws NotFoundException {
        checkExists(id);
        ofy().delete().type(Employee.class).id(id).now();
        logger.info("Deleted Employee with ID: " + id);
    }

    /**
     * List all entities.
     *
     * @param cursor used for pagination to determine which page to return
     * @param limit  the maximum number of entries to return
     * @return a response that encapsulates the result list and the next page token/cursor
     */
    @ApiMethod(
            name = "list",
            path = "employee",
            httpMethod = ApiMethod.HttpMethod.GET)
    public CollectionResponse<Employee> list(@Nullable @Named("cursor") String cursor, @Nullable @Named("limit") Integer limit) {
        limit = limit == null ? DEFAULT_LIST_LIMIT : limit;
        Query<Employee> query = ofy().load().type(Employee.class).limit(limit);
        if (cursor != null) {
            query = query.startAt(Cursor.fromWebSafeString(cursor));
        }
        QueryResultIterator<Employee> queryIterator = query.iterator();
        List<Employee> employeeList = new ArrayList<Employee>(limit);
        while (queryIterator.hasNext()) {
            employeeList.add(queryIterator.next());
        }
        return CollectionResponse.<Employee>builder().setItems(employeeList).setNextPageToken(queryIterator.getCursor().toWebSafeString()).build();
    }

    private void checkExists(Long id) throws NotFoundException {
        try {
            ofy().load().type(Employee.class).id(id).safe();
        } catch (com.googlecode.objectify.NotFoundException e) {
            throw new NotFoundException("Could not find Employee with ID: " + id);
        }
    }
}