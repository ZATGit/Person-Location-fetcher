package com.ts.person.exception;

import org.hibernate.exception.ConstraintViolationException;
import java.sql.SQLException;

public class UniqueConstraintException extends ConstraintViolationException {

    private static final String message = "Cannot add person. Email must be unique";
    private static SQLException SQLException;
    private static final SQLException root = SQLException;
    private static final String constraintName = "UniqueConstraint: Email";

    public UniqueConstraintException() {
        super(message, root, constraintName);
    }
}
