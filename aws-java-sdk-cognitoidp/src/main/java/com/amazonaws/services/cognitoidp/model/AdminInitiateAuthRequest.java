/*
 * Copyright 2015-2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.cognitoidp.model;

import java.io.Serializable;
import javax.annotation.Generated;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * <p>
 * Initiates the authorization request, as an administrator.
 * </p>
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/cognito-idp-2016-04-18/AdminInitiateAuth" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class AdminInitiateAuthRequest extends com.amazonaws.AmazonWebServiceRequest implements Serializable, Cloneable {

    /**
     * <p>
     * The ID of the Amazon Cognito user pool.
     * </p>
     */
    private String userPoolId;
    /**
     * <p>
     * The app client ID.
     * </p>
     */
    private String clientId;
    /**
     * <p>
     * The authentication flow for this call to execute. The API action will depend on this value. For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code> will take in a valid refresh token and return new tokens.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code> will take in <code>USERNAME</code> and <code>SRP_A</code> and return the SRP variables
     * to be used for next challenge execution.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code> will take in <code>USERNAME</code> and <code>PASSWORD</code> and return the next
     * challenge or tokens.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Valid values include:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code>: Authentication flow for the Secure Remote Password (SRP) protocol.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code>/<code>REFRESH_TOKEN</code>: Authentication flow for refreshing the access token
     * and ID token by supplying a valid refresh token.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CUSTOM_AUTH</code>: Custom authentication flow.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code>: Non-SRP authentication flow; you can pass in the USERNAME and PASSWORD directly
     * if the flow is enabled for calling the app client.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code>: Non-SRP authentication flow; USERNAME and PASSWORD are passed directly. If a
     * user migration Lambda trigger is set, this flow will invoke the user migration Lambda if the USERNAME is not
     * found in the user pool.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_USER_PASSWORD_AUTH</code>: Admin-based user password authentication. This replaces the
     * <code>ADMIN_NO_SRP_AUTH</code> authentication flow. In this flow, Cognito receives the password in the request
     * instead of using the SRP process to verify passwords.
     * </p>
     * </li>
     * </ul>
     */
    private String authFlow;
    /**
     * <p>
     * The authentication parameters. These are inputs corresponding to the <code>AuthFlow</code> that you are invoking.
     * The required values depend on the value of <code>AuthFlow</code>:
     * </p>
     * <ul>
     * <li>
     * <p>
     * For <code>USER_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SRP_A</code> (required),
     * <code>SECRET_HASH</code> (required if the app client is configured with a client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>REFRESH_TOKEN_AUTH/REFRESH_TOKEN</code>: <code>REFRESH_TOKEN</code> (required),
     * <code>SECRET_HASH</code> (required if the app client is configured with a client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>ADMIN_NO_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app client is
     * configured with client secret), <code>PASSWORD</code> (required), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>CUSTOM_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app client is
     * configured with client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * </ul>
     */
    private java.util.Map<String, String> authParameters;
    /**
     * <p>
     * A map of custom key-value pairs that you can provide as input for certain custom workflows that this action
     * triggers.
     * </p>
     * <p>
     * You create custom workflows by assigning AWS Lambda functions to user pool triggers. When you use the
     * AdminInitiateAuth API action, Amazon Cognito invokes the AWS Lambda functions that are specified for various
     * triggers. The ClientMetadata value is passed as input to the functions for only the following triggers:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Pre signup
     * </p>
     * </li>
     * <li>
     * <p>
     * Pre authentication
     * </p>
     * </li>
     * <li>
     * <p>
     * User migration
     * </p>
     * </li>
     * </ul>
     * <p>
     * When Amazon Cognito invokes the functions for these triggers, it passes a JSON payload, which the function
     * receives as input. This payload contains a <code>validationData</code> attribute, which provides the data that
     * you assigned to the ClientMetadata parameter in your AdminInitiateAuth request. In your function code in AWS
     * Lambda, you can process the <code>validationData</code> value to enhance your workflow for your specific needs.
     * </p>
     * <p>
     * When you use the AdminInitiateAuth API action, Amazon Cognito also invokes the functions for the following
     * triggers, but it does not provide the ClientMetadata value as input:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Post authentication
     * </p>
     * </li>
     * <li>
     * <p>
     * Custom message
     * </p>
     * </li>
     * <li>
     * <p>
     * Pre token generation
     * </p>
     * </li>
     * <li>
     * <p>
     * Create auth challenge
     * </p>
     * </li>
     * <li>
     * <p>
     * Define auth challenge
     * </p>
     * </li>
     * <li>
     * <p>
     * Verify auth challenge
     * </p>
     * </li>
     * </ul>
     * <p>
     * For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     * >Customizing User Pool Workflows with Lambda Triggers</a> in the <i>Amazon Cognito Developer Guide</i>.
     * </p>
     * <note>
     * <p>
     * Take the following limitations into consideration when you use the ClientMetadata parameter:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Amazon Cognito does not store the ClientMetadata value. This data is available only to AWS Lambda triggers that
     * are assigned to a user pool to support custom workflows. If your user pool configuration does not include
     * triggers, the ClientMetadata parameter serves no purpose.
     * </p>
     * </li>
     * <li>
     * <p>
     * Amazon Cognito does not validate the ClientMetadata value.
     * </p>
     * </li>
     * <li>
     * <p>
     * Amazon Cognito does not encrypt the the ClientMetadata value, so don't use it to provide sensitive information.
     * </p>
     * </li>
     * </ul>
     * </note>
     */
    private java.util.Map<String, String> clientMetadata;
    /**
     * <p>
     * The analytics metadata for collecting Amazon Pinpoint metrics for <code>AdminInitiateAuth</code> calls.
     * </p>
     */
    private AnalyticsMetadataType analyticsMetadata;
    /**
     * <p>
     * Contextual data such as the user's device fingerprint, IP address, or location used for evaluating the risk of an
     * unexpected event by Amazon Cognito advanced security.
     * </p>
     */
    private ContextDataType contextData;

    /**
     * <p>
     * The ID of the Amazon Cognito user pool.
     * </p>
     * 
     * @param userPoolId
     *        The ID of the Amazon Cognito user pool.
     */

    public void setUserPoolId(String userPoolId) {
        this.userPoolId = userPoolId;
    }

    /**
     * <p>
     * The ID of the Amazon Cognito user pool.
     * </p>
     * 
     * @return The ID of the Amazon Cognito user pool.
     */

    public String getUserPoolId() {
        return this.userPoolId;
    }

    /**
     * <p>
     * The ID of the Amazon Cognito user pool.
     * </p>
     * 
     * @param userPoolId
     *        The ID of the Amazon Cognito user pool.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AdminInitiateAuthRequest withUserPoolId(String userPoolId) {
        setUserPoolId(userPoolId);
        return this;
    }

    /**
     * <p>
     * The app client ID.
     * </p>
     * 
     * @param clientId
     *        The app client ID.
     */

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * <p>
     * The app client ID.
     * </p>
     * 
     * @return The app client ID.
     */

    public String getClientId() {
        return this.clientId;
    }

    /**
     * <p>
     * The app client ID.
     * </p>
     * 
     * @param clientId
     *        The app client ID.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AdminInitiateAuthRequest withClientId(String clientId) {
        setClientId(clientId);
        return this;
    }

    /**
     * <p>
     * The authentication flow for this call to execute. The API action will depend on this value. For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code> will take in a valid refresh token and return new tokens.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code> will take in <code>USERNAME</code> and <code>SRP_A</code> and return the SRP variables
     * to be used for next challenge execution.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code> will take in <code>USERNAME</code> and <code>PASSWORD</code> and return the next
     * challenge or tokens.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Valid values include:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code>: Authentication flow for the Secure Remote Password (SRP) protocol.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code>/<code>REFRESH_TOKEN</code>: Authentication flow for refreshing the access token
     * and ID token by supplying a valid refresh token.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CUSTOM_AUTH</code>: Custom authentication flow.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code>: Non-SRP authentication flow; you can pass in the USERNAME and PASSWORD directly
     * if the flow is enabled for calling the app client.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code>: Non-SRP authentication flow; USERNAME and PASSWORD are passed directly. If a
     * user migration Lambda trigger is set, this flow will invoke the user migration Lambda if the USERNAME is not
     * found in the user pool.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_USER_PASSWORD_AUTH</code>: Admin-based user password authentication. This replaces the
     * <code>ADMIN_NO_SRP_AUTH</code> authentication flow. In this flow, Cognito receives the password in the request
     * instead of using the SRP process to verify passwords.
     * </p>
     * </li>
     * </ul>
     * 
     * @param authFlow
     *        The authentication flow for this call to execute. The API action will depend on this value. For
     *        example:</p>
     *        <ul>
     *        <li>
     *        <p>
     *        <code>REFRESH_TOKEN_AUTH</code> will take in a valid refresh token and return new tokens.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_SRP_AUTH</code> will take in <code>USERNAME</code> and <code>SRP_A</code> and return the SRP
     *        variables to be used for next challenge execution.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_PASSWORD_AUTH</code> will take in <code>USERNAME</code> and <code>PASSWORD</code> and return
     *        the next challenge or tokens.
     *        </p>
     *        </li>
     *        </ul>
     *        <p>
     *        Valid values include:
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        <code>USER_SRP_AUTH</code>: Authentication flow for the Secure Remote Password (SRP) protocol.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>REFRESH_TOKEN_AUTH</code>/<code>REFRESH_TOKEN</code>: Authentication flow for refreshing the access
     *        token and ID token by supplying a valid refresh token.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>CUSTOM_AUTH</code>: Custom authentication flow.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>ADMIN_NO_SRP_AUTH</code>: Non-SRP authentication flow; you can pass in the USERNAME and PASSWORD
     *        directly if the flow is enabled for calling the app client.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_PASSWORD_AUTH</code>: Non-SRP authentication flow; USERNAME and PASSWORD are passed directly.
     *        If a user migration Lambda trigger is set, this flow will invoke the user migration Lambda if the USERNAME
     *        is not found in the user pool.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>ADMIN_USER_PASSWORD_AUTH</code>: Admin-based user password authentication. This replaces the
     *        <code>ADMIN_NO_SRP_AUTH</code> authentication flow. In this flow, Cognito receives the password in the
     *        request instead of using the SRP process to verify passwords.
     *        </p>
     *        </li>
     * @see AuthFlowType
     */

    public void setAuthFlow(String authFlow) {
        this.authFlow = authFlow;
    }

    /**
     * <p>
     * The authentication flow for this call to execute. The API action will depend on this value. For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code> will take in a valid refresh token and return new tokens.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code> will take in <code>USERNAME</code> and <code>SRP_A</code> and return the SRP variables
     * to be used for next challenge execution.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code> will take in <code>USERNAME</code> and <code>PASSWORD</code> and return the next
     * challenge or tokens.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Valid values include:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code>: Authentication flow for the Secure Remote Password (SRP) protocol.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code>/<code>REFRESH_TOKEN</code>: Authentication flow for refreshing the access token
     * and ID token by supplying a valid refresh token.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CUSTOM_AUTH</code>: Custom authentication flow.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code>: Non-SRP authentication flow; you can pass in the USERNAME and PASSWORD directly
     * if the flow is enabled for calling the app client.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code>: Non-SRP authentication flow; USERNAME and PASSWORD are passed directly. If a
     * user migration Lambda trigger is set, this flow will invoke the user migration Lambda if the USERNAME is not
     * found in the user pool.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_USER_PASSWORD_AUTH</code>: Admin-based user password authentication. This replaces the
     * <code>ADMIN_NO_SRP_AUTH</code> authentication flow. In this flow, Cognito receives the password in the request
     * instead of using the SRP process to verify passwords.
     * </p>
     * </li>
     * </ul>
     * 
     * @return The authentication flow for this call to execute. The API action will depend on this value. For
     *         example:</p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>REFRESH_TOKEN_AUTH</code> will take in a valid refresh token and return new tokens.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>USER_SRP_AUTH</code> will take in <code>USERNAME</code> and <code>SRP_A</code> and return the SRP
     *         variables to be used for next challenge execution.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>USER_PASSWORD_AUTH</code> will take in <code>USERNAME</code> and <code>PASSWORD</code> and return
     *         the next challenge or tokens.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         Valid values include:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>USER_SRP_AUTH</code>: Authentication flow for the Secure Remote Password (SRP) protocol.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>REFRESH_TOKEN_AUTH</code>/<code>REFRESH_TOKEN</code>: Authentication flow for refreshing the access
     *         token and ID token by supplying a valid refresh token.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>CUSTOM_AUTH</code>: Custom authentication flow.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>ADMIN_NO_SRP_AUTH</code>: Non-SRP authentication flow; you can pass in the USERNAME and PASSWORD
     *         directly if the flow is enabled for calling the app client.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>USER_PASSWORD_AUTH</code>: Non-SRP authentication flow; USERNAME and PASSWORD are passed directly.
     *         If a user migration Lambda trigger is set, this flow will invoke the user migration Lambda if the
     *         USERNAME is not found in the user pool.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>ADMIN_USER_PASSWORD_AUTH</code>: Admin-based user password authentication. This replaces the
     *         <code>ADMIN_NO_SRP_AUTH</code> authentication flow. In this flow, Cognito receives the password in the
     *         request instead of using the SRP process to verify passwords.
     *         </p>
     *         </li>
     * @see AuthFlowType
     */

    public String getAuthFlow() {
        return this.authFlow;
    }

    /**
     * <p>
     * The authentication flow for this call to execute. The API action will depend on this value. For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code> will take in a valid refresh token and return new tokens.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code> will take in <code>USERNAME</code> and <code>SRP_A</code> and return the SRP variables
     * to be used for next challenge execution.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code> will take in <code>USERNAME</code> and <code>PASSWORD</code> and return the next
     * challenge or tokens.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Valid values include:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code>: Authentication flow for the Secure Remote Password (SRP) protocol.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code>/<code>REFRESH_TOKEN</code>: Authentication flow for refreshing the access token
     * and ID token by supplying a valid refresh token.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CUSTOM_AUTH</code>: Custom authentication flow.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code>: Non-SRP authentication flow; you can pass in the USERNAME and PASSWORD directly
     * if the flow is enabled for calling the app client.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code>: Non-SRP authentication flow; USERNAME and PASSWORD are passed directly. If a
     * user migration Lambda trigger is set, this flow will invoke the user migration Lambda if the USERNAME is not
     * found in the user pool.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_USER_PASSWORD_AUTH</code>: Admin-based user password authentication. This replaces the
     * <code>ADMIN_NO_SRP_AUTH</code> authentication flow. In this flow, Cognito receives the password in the request
     * instead of using the SRP process to verify passwords.
     * </p>
     * </li>
     * </ul>
     * 
     * @param authFlow
     *        The authentication flow for this call to execute. The API action will depend on this value. For
     *        example:</p>
     *        <ul>
     *        <li>
     *        <p>
     *        <code>REFRESH_TOKEN_AUTH</code> will take in a valid refresh token and return new tokens.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_SRP_AUTH</code> will take in <code>USERNAME</code> and <code>SRP_A</code> and return the SRP
     *        variables to be used for next challenge execution.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_PASSWORD_AUTH</code> will take in <code>USERNAME</code> and <code>PASSWORD</code> and return
     *        the next challenge or tokens.
     *        </p>
     *        </li>
     *        </ul>
     *        <p>
     *        Valid values include:
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        <code>USER_SRP_AUTH</code>: Authentication flow for the Secure Remote Password (SRP) protocol.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>REFRESH_TOKEN_AUTH</code>/<code>REFRESH_TOKEN</code>: Authentication flow for refreshing the access
     *        token and ID token by supplying a valid refresh token.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>CUSTOM_AUTH</code>: Custom authentication flow.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>ADMIN_NO_SRP_AUTH</code>: Non-SRP authentication flow; you can pass in the USERNAME and PASSWORD
     *        directly if the flow is enabled for calling the app client.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_PASSWORD_AUTH</code>: Non-SRP authentication flow; USERNAME and PASSWORD are passed directly.
     *        If a user migration Lambda trigger is set, this flow will invoke the user migration Lambda if the USERNAME
     *        is not found in the user pool.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>ADMIN_USER_PASSWORD_AUTH</code>: Admin-based user password authentication. This replaces the
     *        <code>ADMIN_NO_SRP_AUTH</code> authentication flow. In this flow, Cognito receives the password in the
     *        request instead of using the SRP process to verify passwords.
     *        </p>
     *        </li>
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see AuthFlowType
     */

    public AdminInitiateAuthRequest withAuthFlow(String authFlow) {
        setAuthFlow(authFlow);
        return this;
    }

    /**
     * <p>
     * The authentication flow for this call to execute. The API action will depend on this value. For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code> will take in a valid refresh token and return new tokens.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code> will take in <code>USERNAME</code> and <code>SRP_A</code> and return the SRP variables
     * to be used for next challenge execution.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code> will take in <code>USERNAME</code> and <code>PASSWORD</code> and return the next
     * challenge or tokens.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Valid values include:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code>: Authentication flow for the Secure Remote Password (SRP) protocol.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code>/<code>REFRESH_TOKEN</code>: Authentication flow for refreshing the access token
     * and ID token by supplying a valid refresh token.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CUSTOM_AUTH</code>: Custom authentication flow.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code>: Non-SRP authentication flow; you can pass in the USERNAME and PASSWORD directly
     * if the flow is enabled for calling the app client.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code>: Non-SRP authentication flow; USERNAME and PASSWORD are passed directly. If a
     * user migration Lambda trigger is set, this flow will invoke the user migration Lambda if the USERNAME is not
     * found in the user pool.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_USER_PASSWORD_AUTH</code>: Admin-based user password authentication. This replaces the
     * <code>ADMIN_NO_SRP_AUTH</code> authentication flow. In this flow, Cognito receives the password in the request
     * instead of using the SRP process to verify passwords.
     * </p>
     * </li>
     * </ul>
     * 
     * @param authFlow
     *        The authentication flow for this call to execute. The API action will depend on this value. For
     *        example:</p>
     *        <ul>
     *        <li>
     *        <p>
     *        <code>REFRESH_TOKEN_AUTH</code> will take in a valid refresh token and return new tokens.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_SRP_AUTH</code> will take in <code>USERNAME</code> and <code>SRP_A</code> and return the SRP
     *        variables to be used for next challenge execution.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_PASSWORD_AUTH</code> will take in <code>USERNAME</code> and <code>PASSWORD</code> and return
     *        the next challenge or tokens.
     *        </p>
     *        </li>
     *        </ul>
     *        <p>
     *        Valid values include:
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        <code>USER_SRP_AUTH</code>: Authentication flow for the Secure Remote Password (SRP) protocol.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>REFRESH_TOKEN_AUTH</code>/<code>REFRESH_TOKEN</code>: Authentication flow for refreshing the access
     *        token and ID token by supplying a valid refresh token.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>CUSTOM_AUTH</code>: Custom authentication flow.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>ADMIN_NO_SRP_AUTH</code>: Non-SRP authentication flow; you can pass in the USERNAME and PASSWORD
     *        directly if the flow is enabled for calling the app client.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_PASSWORD_AUTH</code>: Non-SRP authentication flow; USERNAME and PASSWORD are passed directly.
     *        If a user migration Lambda trigger is set, this flow will invoke the user migration Lambda if the USERNAME
     *        is not found in the user pool.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>ADMIN_USER_PASSWORD_AUTH</code>: Admin-based user password authentication. This replaces the
     *        <code>ADMIN_NO_SRP_AUTH</code> authentication flow. In this flow, Cognito receives the password in the
     *        request instead of using the SRP process to verify passwords.
     *        </p>
     *        </li>
     * @see AuthFlowType
     */

    public void setAuthFlow(AuthFlowType authFlow) {
        withAuthFlow(authFlow);
    }

    /**
     * <p>
     * The authentication flow for this call to execute. The API action will depend on this value. For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code> will take in a valid refresh token and return new tokens.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code> will take in <code>USERNAME</code> and <code>SRP_A</code> and return the SRP variables
     * to be used for next challenge execution.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code> will take in <code>USERNAME</code> and <code>PASSWORD</code> and return the next
     * challenge or tokens.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Valid values include:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>USER_SRP_AUTH</code>: Authentication flow for the Secure Remote Password (SRP) protocol.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>REFRESH_TOKEN_AUTH</code>/<code>REFRESH_TOKEN</code>: Authentication flow for refreshing the access token
     * and ID token by supplying a valid refresh token.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CUSTOM_AUTH</code>: Custom authentication flow.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_NO_SRP_AUTH</code>: Non-SRP authentication flow; you can pass in the USERNAME and PASSWORD directly
     * if the flow is enabled for calling the app client.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_PASSWORD_AUTH</code>: Non-SRP authentication flow; USERNAME and PASSWORD are passed directly. If a
     * user migration Lambda trigger is set, this flow will invoke the user migration Lambda if the USERNAME is not
     * found in the user pool.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ADMIN_USER_PASSWORD_AUTH</code>: Admin-based user password authentication. This replaces the
     * <code>ADMIN_NO_SRP_AUTH</code> authentication flow. In this flow, Cognito receives the password in the request
     * instead of using the SRP process to verify passwords.
     * </p>
     * </li>
     * </ul>
     * 
     * @param authFlow
     *        The authentication flow for this call to execute. The API action will depend on this value. For
     *        example:</p>
     *        <ul>
     *        <li>
     *        <p>
     *        <code>REFRESH_TOKEN_AUTH</code> will take in a valid refresh token and return new tokens.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_SRP_AUTH</code> will take in <code>USERNAME</code> and <code>SRP_A</code> and return the SRP
     *        variables to be used for next challenge execution.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_PASSWORD_AUTH</code> will take in <code>USERNAME</code> and <code>PASSWORD</code> and return
     *        the next challenge or tokens.
     *        </p>
     *        </li>
     *        </ul>
     *        <p>
     *        Valid values include:
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        <code>USER_SRP_AUTH</code>: Authentication flow for the Secure Remote Password (SRP) protocol.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>REFRESH_TOKEN_AUTH</code>/<code>REFRESH_TOKEN</code>: Authentication flow for refreshing the access
     *        token and ID token by supplying a valid refresh token.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>CUSTOM_AUTH</code>: Custom authentication flow.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>ADMIN_NO_SRP_AUTH</code>: Non-SRP authentication flow; you can pass in the USERNAME and PASSWORD
     *        directly if the flow is enabled for calling the app client.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>USER_PASSWORD_AUTH</code>: Non-SRP authentication flow; USERNAME and PASSWORD are passed directly.
     *        If a user migration Lambda trigger is set, this flow will invoke the user migration Lambda if the USERNAME
     *        is not found in the user pool.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        <code>ADMIN_USER_PASSWORD_AUTH</code>: Admin-based user password authentication. This replaces the
     *        <code>ADMIN_NO_SRP_AUTH</code> authentication flow. In this flow, Cognito receives the password in the
     *        request instead of using the SRP process to verify passwords.
     *        </p>
     *        </li>
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see AuthFlowType
     */

    public AdminInitiateAuthRequest withAuthFlow(AuthFlowType authFlow) {
        this.authFlow = authFlow.toString();
        return this;
    }

    /**
     * <p>
     * The authentication parameters. These are inputs corresponding to the <code>AuthFlow</code> that you are invoking.
     * The required values depend on the value of <code>AuthFlow</code>:
     * </p>
     * <ul>
     * <li>
     * <p>
     * For <code>USER_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SRP_A</code> (required),
     * <code>SECRET_HASH</code> (required if the app client is configured with a client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>REFRESH_TOKEN_AUTH/REFRESH_TOKEN</code>: <code>REFRESH_TOKEN</code> (required),
     * <code>SECRET_HASH</code> (required if the app client is configured with a client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>ADMIN_NO_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app client is
     * configured with client secret), <code>PASSWORD</code> (required), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>CUSTOM_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app client is
     * configured with client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * </ul>
     * 
     * @return The authentication parameters. These are inputs corresponding to the <code>AuthFlow</code> that you are
     *         invoking. The required values depend on the value of <code>AuthFlow</code>:</p>
     *         <ul>
     *         <li>
     *         <p>
     *         For <code>USER_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SRP_A</code> (required),
     *         <code>SECRET_HASH</code> (required if the app client is configured with a client secret),
     *         <code>DEVICE_KEY</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For <code>REFRESH_TOKEN_AUTH/REFRESH_TOKEN</code>: <code>REFRESH_TOKEN</code> (required),
     *         <code>SECRET_HASH</code> (required if the app client is configured with a client secret),
     *         <code>DEVICE_KEY</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For <code>ADMIN_NO_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app
     *         client is configured with client secret), <code>PASSWORD</code> (required), <code>DEVICE_KEY</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For <code>CUSTOM_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app client
     *         is configured with client secret), <code>DEVICE_KEY</code>
     *         </p>
     *         </li>
     */

    public java.util.Map<String, String> getAuthParameters() {
        return authParameters;
    }

    /**
     * <p>
     * The authentication parameters. These are inputs corresponding to the <code>AuthFlow</code> that you are invoking.
     * The required values depend on the value of <code>AuthFlow</code>:
     * </p>
     * <ul>
     * <li>
     * <p>
     * For <code>USER_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SRP_A</code> (required),
     * <code>SECRET_HASH</code> (required if the app client is configured with a client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>REFRESH_TOKEN_AUTH/REFRESH_TOKEN</code>: <code>REFRESH_TOKEN</code> (required),
     * <code>SECRET_HASH</code> (required if the app client is configured with a client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>ADMIN_NO_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app client is
     * configured with client secret), <code>PASSWORD</code> (required), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>CUSTOM_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app client is
     * configured with client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * </ul>
     * 
     * @param authParameters
     *        The authentication parameters. These are inputs corresponding to the <code>AuthFlow</code> that you are
     *        invoking. The required values depend on the value of <code>AuthFlow</code>:</p>
     *        <ul>
     *        <li>
     *        <p>
     *        For <code>USER_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SRP_A</code> (required),
     *        <code>SECRET_HASH</code> (required if the app client is configured with a client secret),
     *        <code>DEVICE_KEY</code>
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        For <code>REFRESH_TOKEN_AUTH/REFRESH_TOKEN</code>: <code>REFRESH_TOKEN</code> (required),
     *        <code>SECRET_HASH</code> (required if the app client is configured with a client secret),
     *        <code>DEVICE_KEY</code>
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        For <code>ADMIN_NO_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app
     *        client is configured with client secret), <code>PASSWORD</code> (required), <code>DEVICE_KEY</code>
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        For <code>CUSTOM_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app client is
     *        configured with client secret), <code>DEVICE_KEY</code>
     *        </p>
     *        </li>
     */

    public void setAuthParameters(java.util.Map<String, String> authParameters) {
        this.authParameters = authParameters;
    }

    /**
     * <p>
     * The authentication parameters. These are inputs corresponding to the <code>AuthFlow</code> that you are invoking.
     * The required values depend on the value of <code>AuthFlow</code>:
     * </p>
     * <ul>
     * <li>
     * <p>
     * For <code>USER_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SRP_A</code> (required),
     * <code>SECRET_HASH</code> (required if the app client is configured with a client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>REFRESH_TOKEN_AUTH/REFRESH_TOKEN</code>: <code>REFRESH_TOKEN</code> (required),
     * <code>SECRET_HASH</code> (required if the app client is configured with a client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>ADMIN_NO_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app client is
     * configured with client secret), <code>PASSWORD</code> (required), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * For <code>CUSTOM_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app client is
     * configured with client secret), <code>DEVICE_KEY</code>
     * </p>
     * </li>
     * </ul>
     * 
     * @param authParameters
     *        The authentication parameters. These are inputs corresponding to the <code>AuthFlow</code> that you are
     *        invoking. The required values depend on the value of <code>AuthFlow</code>:</p>
     *        <ul>
     *        <li>
     *        <p>
     *        For <code>USER_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SRP_A</code> (required),
     *        <code>SECRET_HASH</code> (required if the app client is configured with a client secret),
     *        <code>DEVICE_KEY</code>
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        For <code>REFRESH_TOKEN_AUTH/REFRESH_TOKEN</code>: <code>REFRESH_TOKEN</code> (required),
     *        <code>SECRET_HASH</code> (required if the app client is configured with a client secret),
     *        <code>DEVICE_KEY</code>
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        For <code>ADMIN_NO_SRP_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app
     *        client is configured with client secret), <code>PASSWORD</code> (required), <code>DEVICE_KEY</code>
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        For <code>CUSTOM_AUTH</code>: <code>USERNAME</code> (required), <code>SECRET_HASH</code> (if app client is
     *        configured with client secret), <code>DEVICE_KEY</code>
     *        </p>
     *        </li>
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AdminInitiateAuthRequest withAuthParameters(java.util.Map<String, String> authParameters) {
        setAuthParameters(authParameters);
        return this;
    }

    /**
     * Add a single AuthParameters entry
     *
     * @see AdminInitiateAuthRequest#withAuthParameters
     * @returns a reference to this object so that method calls can be chained together.
     */

    public AdminInitiateAuthRequest addAuthParametersEntry(String key, String value) {
        if (null == this.authParameters) {
            this.authParameters = new java.util.HashMap<String, String>();
        }
        if (this.authParameters.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.authParameters.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into AuthParameters.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AdminInitiateAuthRequest clearAuthParametersEntries() {
        this.authParameters = null;
        return this;
    }

    /**
     * <p>
     * A map of custom key-value pairs that you can provide as input for certain custom workflows that this action
     * triggers.
     * </p>
     * <p>
     * You create custom workflows by assigning AWS Lambda functions to user pool triggers. When you use the
     * AdminInitiateAuth API action, Amazon Cognito invokes the AWS Lambda functions that are specified for various
     * triggers. The ClientMetadata value is passed as input to the functions for only the following triggers:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Pre signup
     * </p>
     * </li>
     * <li>
     * <p>
     * Pre authentication
     * </p>
     * </li>
     * <li>
     * <p>
     * User migration
     * </p>
     * </li>
     * </ul>
     * <p>
     * When Amazon Cognito invokes the functions for these triggers, it passes a JSON payload, which the function
     * receives as input. This payload contains a <code>validationData</code> attribute, which provides the data that
     * you assigned to the ClientMetadata parameter in your AdminInitiateAuth request. In your function code in AWS
     * Lambda, you can process the <code>validationData</code> value to enhance your workflow for your specific needs.
     * </p>
     * <p>
     * When you use the AdminInitiateAuth API action, Amazon Cognito also invokes the functions for the following
     * triggers, but it does not provide the ClientMetadata value as input:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Post authentication
     * </p>
     * </li>
     * <li>
     * <p>
     * Custom message
     * </p>
     * </li>
     * <li>
     * <p>
     * Pre token generation
     * </p>
     * </li>
     * <li>
     * <p>
     * Create auth challenge
     * </p>
     * </li>
     * <li>
     * <p>
     * Define auth challenge
     * </p>
     * </li>
     * <li>
     * <p>
     * Verify auth challenge
     * </p>
     * </li>
     * </ul>
     * <p>
     * For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     * >Customizing User Pool Workflows with Lambda Triggers</a> in the <i>Amazon Cognito Developer Guide</i>.
     * </p>
     * <note>
     * <p>
     * Take the following limitations into consideration when you use the ClientMetadata parameter:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Amazon Cognito does not store the ClientMetadata value. This data is available only to AWS Lambda triggers that
     * are assigned to a user pool to support custom workflows. If your user pool configuration does not include
     * triggers, the ClientMetadata parameter serves no purpose.
     * </p>
     * </li>
     * <li>
     * <p>
     * Amazon Cognito does not validate the ClientMetadata value.
     * </p>
     * </li>
     * <li>
     * <p>
     * Amazon Cognito does not encrypt the the ClientMetadata value, so don't use it to provide sensitive information.
     * </p>
     * </li>
     * </ul>
     * </note>
     * 
     * @return A map of custom key-value pairs that you can provide as input for certain custom workflows that this
     *         action triggers.</p>
     *         <p>
     *         You create custom workflows by assigning AWS Lambda functions to user pool triggers. When you use the
     *         AdminInitiateAuth API action, Amazon Cognito invokes the AWS Lambda functions that are specified for
     *         various triggers. The ClientMetadata value is passed as input to the functions for only the following
     *         triggers:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Pre signup
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Pre authentication
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         User migration
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         When Amazon Cognito invokes the functions for these triggers, it passes a JSON payload, which the
     *         function receives as input. This payload contains a <code>validationData</code> attribute, which provides
     *         the data that you assigned to the ClientMetadata parameter in your AdminInitiateAuth request. In your
     *         function code in AWS Lambda, you can process the <code>validationData</code> value to enhance your
     *         workflow for your specific needs.
     *         </p>
     *         <p>
     *         When you use the AdminInitiateAuth API action, Amazon Cognito also invokes the functions for the
     *         following triggers, but it does not provide the ClientMetadata value as input:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Post authentication
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Custom message
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Pre token generation
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Create auth challenge
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Define auth challenge
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Verify auth challenge
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         For more information, see <a href=
     *         "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     *         >Customizing User Pool Workflows with Lambda Triggers</a> in the <i>Amazon Cognito Developer Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         Take the following limitations into consideration when you use the ClientMetadata parameter:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Amazon Cognito does not store the ClientMetadata value. This data is available only to AWS Lambda
     *         triggers that are assigned to a user pool to support custom workflows. If your user pool configuration
     *         does not include triggers, the ClientMetadata parameter serves no purpose.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Amazon Cognito does not validate the ClientMetadata value.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Amazon Cognito does not encrypt the the ClientMetadata value, so don't use it to provide sensitive
     *         information.
     *         </p>
     *         </li>
     *         </ul>
     */

    public java.util.Map<String, String> getClientMetadata() {
        return clientMetadata;
    }

    /**
     * <p>
     * A map of custom key-value pairs that you can provide as input for certain custom workflows that this action
     * triggers.
     * </p>
     * <p>
     * You create custom workflows by assigning AWS Lambda functions to user pool triggers. When you use the
     * AdminInitiateAuth API action, Amazon Cognito invokes the AWS Lambda functions that are specified for various
     * triggers. The ClientMetadata value is passed as input to the functions for only the following triggers:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Pre signup
     * </p>
     * </li>
     * <li>
     * <p>
     * Pre authentication
     * </p>
     * </li>
     * <li>
     * <p>
     * User migration
     * </p>
     * </li>
     * </ul>
     * <p>
     * When Amazon Cognito invokes the functions for these triggers, it passes a JSON payload, which the function
     * receives as input. This payload contains a <code>validationData</code> attribute, which provides the data that
     * you assigned to the ClientMetadata parameter in your AdminInitiateAuth request. In your function code in AWS
     * Lambda, you can process the <code>validationData</code> value to enhance your workflow for your specific needs.
     * </p>
     * <p>
     * When you use the AdminInitiateAuth API action, Amazon Cognito also invokes the functions for the following
     * triggers, but it does not provide the ClientMetadata value as input:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Post authentication
     * </p>
     * </li>
     * <li>
     * <p>
     * Custom message
     * </p>
     * </li>
     * <li>
     * <p>
     * Pre token generation
     * </p>
     * </li>
     * <li>
     * <p>
     * Create auth challenge
     * </p>
     * </li>
     * <li>
     * <p>
     * Define auth challenge
     * </p>
     * </li>
     * <li>
     * <p>
     * Verify auth challenge
     * </p>
     * </li>
     * </ul>
     * <p>
     * For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     * >Customizing User Pool Workflows with Lambda Triggers</a> in the <i>Amazon Cognito Developer Guide</i>.
     * </p>
     * <note>
     * <p>
     * Take the following limitations into consideration when you use the ClientMetadata parameter:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Amazon Cognito does not store the ClientMetadata value. This data is available only to AWS Lambda triggers that
     * are assigned to a user pool to support custom workflows. If your user pool configuration does not include
     * triggers, the ClientMetadata parameter serves no purpose.
     * </p>
     * </li>
     * <li>
     * <p>
     * Amazon Cognito does not validate the ClientMetadata value.
     * </p>
     * </li>
     * <li>
     * <p>
     * Amazon Cognito does not encrypt the the ClientMetadata value, so don't use it to provide sensitive information.
     * </p>
     * </li>
     * </ul>
     * </note>
     * 
     * @param clientMetadata
     *        A map of custom key-value pairs that you can provide as input for certain custom workflows that this
     *        action triggers.</p>
     *        <p>
     *        You create custom workflows by assigning AWS Lambda functions to user pool triggers. When you use the
     *        AdminInitiateAuth API action, Amazon Cognito invokes the AWS Lambda functions that are specified for
     *        various triggers. The ClientMetadata value is passed as input to the functions for only the following
     *        triggers:
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        Pre signup
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Pre authentication
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        User migration
     *        </p>
     *        </li>
     *        </ul>
     *        <p>
     *        When Amazon Cognito invokes the functions for these triggers, it passes a JSON payload, which the function
     *        receives as input. This payload contains a <code>validationData</code> attribute, which provides the data
     *        that you assigned to the ClientMetadata parameter in your AdminInitiateAuth request. In your function code
     *        in AWS Lambda, you can process the <code>validationData</code> value to enhance your workflow for your
     *        specific needs.
     *        </p>
     *        <p>
     *        When you use the AdminInitiateAuth API action, Amazon Cognito also invokes the functions for the following
     *        triggers, but it does not provide the ClientMetadata value as input:
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        Post authentication
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Custom message
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Pre token generation
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Create auth challenge
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Define auth challenge
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Verify auth challenge
     *        </p>
     *        </li>
     *        </ul>
     *        <p>
     *        For more information, see <a href=
     *        "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     *        >Customizing User Pool Workflows with Lambda Triggers</a> in the <i>Amazon Cognito Developer Guide</i>.
     *        </p>
     *        <note>
     *        <p>
     *        Take the following limitations into consideration when you use the ClientMetadata parameter:
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        Amazon Cognito does not store the ClientMetadata value. This data is available only to AWS Lambda triggers
     *        that are assigned to a user pool to support custom workflows. If your user pool configuration does not
     *        include triggers, the ClientMetadata parameter serves no purpose.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Amazon Cognito does not validate the ClientMetadata value.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Amazon Cognito does not encrypt the the ClientMetadata value, so don't use it to provide sensitive
     *        information.
     *        </p>
     *        </li>
     *        </ul>
     */

    public void setClientMetadata(java.util.Map<String, String> clientMetadata) {
        this.clientMetadata = clientMetadata;
    }

    /**
     * <p>
     * A map of custom key-value pairs that you can provide as input for certain custom workflows that this action
     * triggers.
     * </p>
     * <p>
     * You create custom workflows by assigning AWS Lambda functions to user pool triggers. When you use the
     * AdminInitiateAuth API action, Amazon Cognito invokes the AWS Lambda functions that are specified for various
     * triggers. The ClientMetadata value is passed as input to the functions for only the following triggers:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Pre signup
     * </p>
     * </li>
     * <li>
     * <p>
     * Pre authentication
     * </p>
     * </li>
     * <li>
     * <p>
     * User migration
     * </p>
     * </li>
     * </ul>
     * <p>
     * When Amazon Cognito invokes the functions for these triggers, it passes a JSON payload, which the function
     * receives as input. This payload contains a <code>validationData</code> attribute, which provides the data that
     * you assigned to the ClientMetadata parameter in your AdminInitiateAuth request. In your function code in AWS
     * Lambda, you can process the <code>validationData</code> value to enhance your workflow for your specific needs.
     * </p>
     * <p>
     * When you use the AdminInitiateAuth API action, Amazon Cognito also invokes the functions for the following
     * triggers, but it does not provide the ClientMetadata value as input:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Post authentication
     * </p>
     * </li>
     * <li>
     * <p>
     * Custom message
     * </p>
     * </li>
     * <li>
     * <p>
     * Pre token generation
     * </p>
     * </li>
     * <li>
     * <p>
     * Create auth challenge
     * </p>
     * </li>
     * <li>
     * <p>
     * Define auth challenge
     * </p>
     * </li>
     * <li>
     * <p>
     * Verify auth challenge
     * </p>
     * </li>
     * </ul>
     * <p>
     * For more information, see <a href=
     * "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     * >Customizing User Pool Workflows with Lambda Triggers</a> in the <i>Amazon Cognito Developer Guide</i>.
     * </p>
     * <note>
     * <p>
     * Take the following limitations into consideration when you use the ClientMetadata parameter:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Amazon Cognito does not store the ClientMetadata value. This data is available only to AWS Lambda triggers that
     * are assigned to a user pool to support custom workflows. If your user pool configuration does not include
     * triggers, the ClientMetadata parameter serves no purpose.
     * </p>
     * </li>
     * <li>
     * <p>
     * Amazon Cognito does not validate the ClientMetadata value.
     * </p>
     * </li>
     * <li>
     * <p>
     * Amazon Cognito does not encrypt the the ClientMetadata value, so don't use it to provide sensitive information.
     * </p>
     * </li>
     * </ul>
     * </note>
     * 
     * @param clientMetadata
     *        A map of custom key-value pairs that you can provide as input for certain custom workflows that this
     *        action triggers.</p>
     *        <p>
     *        You create custom workflows by assigning AWS Lambda functions to user pool triggers. When you use the
     *        AdminInitiateAuth API action, Amazon Cognito invokes the AWS Lambda functions that are specified for
     *        various triggers. The ClientMetadata value is passed as input to the functions for only the following
     *        triggers:
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        Pre signup
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Pre authentication
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        User migration
     *        </p>
     *        </li>
     *        </ul>
     *        <p>
     *        When Amazon Cognito invokes the functions for these triggers, it passes a JSON payload, which the function
     *        receives as input. This payload contains a <code>validationData</code> attribute, which provides the data
     *        that you assigned to the ClientMetadata parameter in your AdminInitiateAuth request. In your function code
     *        in AWS Lambda, you can process the <code>validationData</code> value to enhance your workflow for your
     *        specific needs.
     *        </p>
     *        <p>
     *        When you use the AdminInitiateAuth API action, Amazon Cognito also invokes the functions for the following
     *        triggers, but it does not provide the ClientMetadata value as input:
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        Post authentication
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Custom message
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Pre token generation
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Create auth challenge
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Define auth challenge
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Verify auth challenge
     *        </p>
     *        </li>
     *        </ul>
     *        <p>
     *        For more information, see <a href=
     *        "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html"
     *        >Customizing User Pool Workflows with Lambda Triggers</a> in the <i>Amazon Cognito Developer Guide</i>.
     *        </p>
     *        <note>
     *        <p>
     *        Take the following limitations into consideration when you use the ClientMetadata parameter:
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        Amazon Cognito does not store the ClientMetadata value. This data is available only to AWS Lambda triggers
     *        that are assigned to a user pool to support custom workflows. If your user pool configuration does not
     *        include triggers, the ClientMetadata parameter serves no purpose.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Amazon Cognito does not validate the ClientMetadata value.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        Amazon Cognito does not encrypt the the ClientMetadata value, so don't use it to provide sensitive
     *        information.
     *        </p>
     *        </li>
     *        </ul>
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AdminInitiateAuthRequest withClientMetadata(java.util.Map<String, String> clientMetadata) {
        setClientMetadata(clientMetadata);
        return this;
    }

    /**
     * Add a single ClientMetadata entry
     *
     * @see AdminInitiateAuthRequest#withClientMetadata
     * @returns a reference to this object so that method calls can be chained together.
     */

    public AdminInitiateAuthRequest addClientMetadataEntry(String key, String value) {
        if (null == this.clientMetadata) {
            this.clientMetadata = new java.util.HashMap<String, String>();
        }
        if (this.clientMetadata.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.clientMetadata.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ClientMetadata.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AdminInitiateAuthRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    /**
     * <p>
     * The analytics metadata for collecting Amazon Pinpoint metrics for <code>AdminInitiateAuth</code> calls.
     * </p>
     * 
     * @param analyticsMetadata
     *        The analytics metadata for collecting Amazon Pinpoint metrics for <code>AdminInitiateAuth</code> calls.
     */

    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadata) {
        this.analyticsMetadata = analyticsMetadata;
    }

    /**
     * <p>
     * The analytics metadata for collecting Amazon Pinpoint metrics for <code>AdminInitiateAuth</code> calls.
     * </p>
     * 
     * @return The analytics metadata for collecting Amazon Pinpoint metrics for <code>AdminInitiateAuth</code> calls.
     */

    public AnalyticsMetadataType getAnalyticsMetadata() {
        return this.analyticsMetadata;
    }

    /**
     * <p>
     * The analytics metadata for collecting Amazon Pinpoint metrics for <code>AdminInitiateAuth</code> calls.
     * </p>
     * 
     * @param analyticsMetadata
     *        The analytics metadata for collecting Amazon Pinpoint metrics for <code>AdminInitiateAuth</code> calls.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AdminInitiateAuthRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadata) {
        setAnalyticsMetadata(analyticsMetadata);
        return this;
    }

    /**
     * <p>
     * Contextual data such as the user's device fingerprint, IP address, or location used for evaluating the risk of an
     * unexpected event by Amazon Cognito advanced security.
     * </p>
     * 
     * @param contextData
     *        Contextual data such as the user's device fingerprint, IP address, or location used for evaluating the
     *        risk of an unexpected event by Amazon Cognito advanced security.
     */

    public void setContextData(ContextDataType contextData) {
        this.contextData = contextData;
    }

    /**
     * <p>
     * Contextual data such as the user's device fingerprint, IP address, or location used for evaluating the risk of an
     * unexpected event by Amazon Cognito advanced security.
     * </p>
     * 
     * @return Contextual data such as the user's device fingerprint, IP address, or location used for evaluating the
     *         risk of an unexpected event by Amazon Cognito advanced security.
     */

    public ContextDataType getContextData() {
        return this.contextData;
    }

    /**
     * <p>
     * Contextual data such as the user's device fingerprint, IP address, or location used for evaluating the risk of an
     * unexpected event by Amazon Cognito advanced security.
     * </p>
     * 
     * @param contextData
     *        Contextual data such as the user's device fingerprint, IP address, or location used for evaluating the
     *        risk of an unexpected event by Amazon Cognito advanced security.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AdminInitiateAuthRequest withContextData(ContextDataType contextData) {
        setContextData(contextData);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null)
            sb.append("UserPoolId: ").append(getUserPoolId()).append(",");
        if (getClientId() != null)
            sb.append("ClientId: ").append("***Sensitive Data Redacted***").append(",");
        if (getAuthFlow() != null)
            sb.append("AuthFlow: ").append(getAuthFlow()).append(",");
        if (getAuthParameters() != null)
            sb.append("AuthParameters: ").append("***Sensitive Data Redacted***").append(",");
        if (getClientMetadata() != null)
            sb.append("ClientMetadata: ").append(getClientMetadata()).append(",");
        if (getAnalyticsMetadata() != null)
            sb.append("AnalyticsMetadata: ").append(getAnalyticsMetadata()).append(",");
        if (getContextData() != null)
            sb.append("ContextData: ").append(getContextData());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof AdminInitiateAuthRequest == false)
            return false;
        AdminInitiateAuthRequest other = (AdminInitiateAuthRequest) obj;
        if (other.getUserPoolId() == null ^ this.getUserPoolId() == null)
            return false;
        if (other.getUserPoolId() != null && other.getUserPoolId().equals(this.getUserPoolId()) == false)
            return false;
        if (other.getClientId() == null ^ this.getClientId() == null)
            return false;
        if (other.getClientId() != null && other.getClientId().equals(this.getClientId()) == false)
            return false;
        if (other.getAuthFlow() == null ^ this.getAuthFlow() == null)
            return false;
        if (other.getAuthFlow() != null && other.getAuthFlow().equals(this.getAuthFlow()) == false)
            return false;
        if (other.getAuthParameters() == null ^ this.getAuthParameters() == null)
            return false;
        if (other.getAuthParameters() != null && other.getAuthParameters().equals(this.getAuthParameters()) == false)
            return false;
        if (other.getClientMetadata() == null ^ this.getClientMetadata() == null)
            return false;
        if (other.getClientMetadata() != null && other.getClientMetadata().equals(this.getClientMetadata()) == false)
            return false;
        if (other.getAnalyticsMetadata() == null ^ this.getAnalyticsMetadata() == null)
            return false;
        if (other.getAnalyticsMetadata() != null && other.getAnalyticsMetadata().equals(this.getAnalyticsMetadata()) == false)
            return false;
        if (other.getContextData() == null ^ this.getContextData() == null)
            return false;
        if (other.getContextData() != null && other.getContextData().equals(this.getContextData()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getUserPoolId() == null) ? 0 : getUserPoolId().hashCode());
        hashCode = prime * hashCode + ((getClientId() == null) ? 0 : getClientId().hashCode());
        hashCode = prime * hashCode + ((getAuthFlow() == null) ? 0 : getAuthFlow().hashCode());
        hashCode = prime * hashCode + ((getAuthParameters() == null) ? 0 : getAuthParameters().hashCode());
        hashCode = prime * hashCode + ((getClientMetadata() == null) ? 0 : getClientMetadata().hashCode());
        hashCode = prime * hashCode + ((getAnalyticsMetadata() == null) ? 0 : getAnalyticsMetadata().hashCode());
        hashCode = prime * hashCode + ((getContextData() == null) ? 0 : getContextData().hashCode());
        return hashCode;
    }

    @Override
    public AdminInitiateAuthRequest clone() {
        return (AdminInitiateAuthRequest) super.clone();
    }

}
