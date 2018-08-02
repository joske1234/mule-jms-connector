/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions.jms.api.message;

import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;

import javax.jms.Message;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains all the metadata of a JMS {@link Message}, it carries information such as the Headers,
 * the Properties and the required ID for performing an ACK on the Message.
 * <p>
 *
 * @since 1.0
 */
public class JmsAttributes implements org.mule.jms.commons.api.message.JmsAttributes {

  private static final long serialVersionUID = -8148917084189760450L;

  /**
   * Container element for all the properties present in a JMS Message
   */
  @Parameter
  private final JmsMessageProperties properties;

  /**
   * All the possible headers of a JMS Message
   */
  @Parameter
  private final JmsHeaders headers;

  /**
   * The session ACK ID required to ACK a the current Message if one is available, or null otherwise.
   */
  @Parameter
  @Optional
  private final String ackId;

  public JmsAttributes(JmsMessageProperties properties, JmsHeaders headers, String ackId) {
    this.properties = properties;
    this.headers = headers;
    this.ackId = ackId;
  }

  @Override
  public JmsMessageProperties getProperties() {
    return properties;
  }

  @Override
  public JmsHeaders getHeaders() {
    return headers;
  }

  @Override
  public String getAckId() {
    return ackId;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, MULTI_LINE_STYLE);
  }
}
