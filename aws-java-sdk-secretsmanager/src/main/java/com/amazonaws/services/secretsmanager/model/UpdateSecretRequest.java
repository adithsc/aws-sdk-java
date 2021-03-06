/*
 * Copyright 2013-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonaws.services.secretsmanager.model;

import java.io.Serializable;
import javax.annotation.Generated;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/secretsmanager-2017-10-17/UpdateSecret" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class UpdateSecretRequest extends com.amazonaws.AmazonWebServiceRequest implements Serializable, Cloneable {

    /**
     * <p>
     * Specifies the secret that you want to update or to which you want to add a new version. You can specify either
     * the Amazon Resource Name (ARN) or the friendly name of the secret.
     * </p>
     */
    private String secretId;
    /**
     * <p>
     * (Optional) If you want to add a new version to the secret, this parameter specifies a unique identifier for the
     * new version that helps ensure idempotency.
     * </p>
     * <p>
     * If you use the AWS CLI or one of the AWS SDK to call this operation, then you can leave this parameter empty. The
     * CLI or SDK generates a random UUID for you and includes that in the request. If you don't use the SDK and instead
     * generate a raw HTTP request to the Secrets Manager service endpoint, then you must generate a
     * <code>ClientRequestToken</code> yourself for new versions and include that value in the request.
     * </p>
     * <p>
     * You typically only need to interact with this value if you implement your own retry logic and want to ensure that
     * a given secret is not created twice. We recommend that you generate a <a
     * href="https://wikipedia.org/wiki/Universally_unique_identifier">UUID-type</a> value to ensure uniqueness within
     * the specified secret.
     * </p>
     * <p>
     * Secrets Manager uses this value to prevent the accidental creation of duplicate versions if there are failures
     * and retries during the Lambda rotation function's processing.
     * </p>
     * <ul>
     * <li>
     * <p>
     * If the <code>ClientRequestToken</code> value isn't already associated with a version of the secret then a new
     * version of the secret is created.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a version with this value already exists and that version's <code>SecretString</code> and
     * <code>SecretBinary</code> values are the same as those in the request then the request is ignored (the operation
     * is idempotent).
     * </p>
     * </li>
     * <li>
     * <p>
     * If a version with this value already exists and that version's <code>SecretString</code> and
     * <code>SecretBinary</code> values are different from the request then an error occurs because you cannot modify an
     * existing secret value.
     * </p>
     * </li>
     * </ul>
     * <p>
     * This value becomes the <code>SecretVersionId</code> of the new version.
     * </p>
     */
    private String clientRequestToken;
    /**
     * <p>
     * (Optional) Specifies a user-provided description of the secret.
     * </p>
     */
    private String description;
    /**
     * <p>
     * (Optional) Specifies the ARN or alias of the KMS customer master key (CMK) to be used to encrypt the protected
     * text in the versions of this secret.
     * </p>
     * <p>
     * If you don't specify this value, then Secrets Manager defaults to using the default CMK in the account (the one
     * named <code>aws/secretsmanager</code>). If a KMS CMK with that name doesn't exist, then Secrets Manager creates
     * it for you automatically the first time it needs to encrypt a version's <code>Plaintext</code> or
     * <code>PlaintextString</code> fields.
     * </p>
     * <important>
     * <p>
     * You can only use the account's default CMK to encrypt and decrypt if you call this operation using credentials
     * from the same account that owns the secret. If the secret is in a different account, then you must create a
     * custom CMK and provide the ARN in this field.
     * </p>
     * </important>
     */
    private String kmsKeyId;
    /**
     * <p>
     * (Optional) Specifies binary data that you want to encrypt and store in the new version of the secret. To use this
     * parameter in the command-line tools, we recommend that you store your binary data in a file and then use the
     * appropriate technique for your tool to pass the contents of the file as a parameter. Either
     * <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot both be
     * empty.
     * </p>
     * <p>
     * This parameter is not accessible using the Secrets Manager console.
     * </p>
     */
    private java.nio.ByteBuffer secretBinary;
    /**
     * <p>
     * (Optional) Specifies text data that you want to encrypt and store in this new version of the secret. Either
     * <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot both be
     * empty.
     * </p>
     * <p>
     * If you create this secret by using the Secrets Manager console then Secrets Manager puts the protected secret
     * text in only the <code>SecretString</code> parameter. The Secrets Manager console stores the information as a
     * JSON structure of key/value pairs that the default Lambda rotation function knows how to parse.
     * </p>
     * <p>
     * For storing multiple values, we recommend that you use a JSON text string argument and specify key/value pairs.
     * For information on how to format a JSON parameter for the various command line tool environments, see <a
     * href="http://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html#cli-using-param-json">Using JSON for
     * Parameters</a> in the <i>AWS CLI User Guide</i>.
     * </p>
     */
    private String secretString;

    /**
     * <p>
     * Specifies the secret that you want to update or to which you want to add a new version. You can specify either
     * the Amazon Resource Name (ARN) or the friendly name of the secret.
     * </p>
     * 
     * @param secretId
     *        Specifies the secret that you want to update or to which you want to add a new version. You can specify
     *        either the Amazon Resource Name (ARN) or the friendly name of the secret.
     */

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    /**
     * <p>
     * Specifies the secret that you want to update or to which you want to add a new version. You can specify either
     * the Amazon Resource Name (ARN) or the friendly name of the secret.
     * </p>
     * 
     * @return Specifies the secret that you want to update or to which you want to add a new version. You can specify
     *         either the Amazon Resource Name (ARN) or the friendly name of the secret.
     */

    public String getSecretId() {
        return this.secretId;
    }

    /**
     * <p>
     * Specifies the secret that you want to update or to which you want to add a new version. You can specify either
     * the Amazon Resource Name (ARN) or the friendly name of the secret.
     * </p>
     * 
     * @param secretId
     *        Specifies the secret that you want to update or to which you want to add a new version. You can specify
     *        either the Amazon Resource Name (ARN) or the friendly name of the secret.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateSecretRequest withSecretId(String secretId) {
        setSecretId(secretId);
        return this;
    }

    /**
     * <p>
     * (Optional) If you want to add a new version to the secret, this parameter specifies a unique identifier for the
     * new version that helps ensure idempotency.
     * </p>
     * <p>
     * If you use the AWS CLI or one of the AWS SDK to call this operation, then you can leave this parameter empty. The
     * CLI or SDK generates a random UUID for you and includes that in the request. If you don't use the SDK and instead
     * generate a raw HTTP request to the Secrets Manager service endpoint, then you must generate a
     * <code>ClientRequestToken</code> yourself for new versions and include that value in the request.
     * </p>
     * <p>
     * You typically only need to interact with this value if you implement your own retry logic and want to ensure that
     * a given secret is not created twice. We recommend that you generate a <a
     * href="https://wikipedia.org/wiki/Universally_unique_identifier">UUID-type</a> value to ensure uniqueness within
     * the specified secret.
     * </p>
     * <p>
     * Secrets Manager uses this value to prevent the accidental creation of duplicate versions if there are failures
     * and retries during the Lambda rotation function's processing.
     * </p>
     * <ul>
     * <li>
     * <p>
     * If the <code>ClientRequestToken</code> value isn't already associated with a version of the secret then a new
     * version of the secret is created.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a version with this value already exists and that version's <code>SecretString</code> and
     * <code>SecretBinary</code> values are the same as those in the request then the request is ignored (the operation
     * is idempotent).
     * </p>
     * </li>
     * <li>
     * <p>
     * If a version with this value already exists and that version's <code>SecretString</code> and
     * <code>SecretBinary</code> values are different from the request then an error occurs because you cannot modify an
     * existing secret value.
     * </p>
     * </li>
     * </ul>
     * <p>
     * This value becomes the <code>SecretVersionId</code> of the new version.
     * </p>
     * 
     * @param clientRequestToken
     *        (Optional) If you want to add a new version to the secret, this parameter specifies a unique identifier
     *        for the new version that helps ensure idempotency. </p>
     *        <p>
     *        If you use the AWS CLI or one of the AWS SDK to call this operation, then you can leave this parameter
     *        empty. The CLI or SDK generates a random UUID for you and includes that in the request. If you don't use
     *        the SDK and instead generate a raw HTTP request to the Secrets Manager service endpoint, then you must
     *        generate a <code>ClientRequestToken</code> yourself for new versions and include that value in the
     *        request.
     *        </p>
     *        <p>
     *        You typically only need to interact with this value if you implement your own retry logic and want to
     *        ensure that a given secret is not created twice. We recommend that you generate a <a
     *        href="https://wikipedia.org/wiki/Universally_unique_identifier">UUID-type</a> value to ensure uniqueness
     *        within the specified secret.
     *        </p>
     *        <p>
     *        Secrets Manager uses this value to prevent the accidental creation of duplicate versions if there are
     *        failures and retries during the Lambda rotation function's processing.
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        If the <code>ClientRequestToken</code> value isn't already associated with a version of the secret then a
     *        new version of the secret is created.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        If a version with this value already exists and that version's <code>SecretString</code> and
     *        <code>SecretBinary</code> values are the same as those in the request then the request is ignored (the
     *        operation is idempotent).
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        If a version with this value already exists and that version's <code>SecretString</code> and
     *        <code>SecretBinary</code> values are different from the request then an error occurs because you cannot
     *        modify an existing secret value.
     *        </p>
     *        </li>
     *        </ul>
     *        <p>
     *        This value becomes the <code>SecretVersionId</code> of the new version.
     */

    public void setClientRequestToken(String clientRequestToken) {
        this.clientRequestToken = clientRequestToken;
    }

    /**
     * <p>
     * (Optional) If you want to add a new version to the secret, this parameter specifies a unique identifier for the
     * new version that helps ensure idempotency.
     * </p>
     * <p>
     * If you use the AWS CLI or one of the AWS SDK to call this operation, then you can leave this parameter empty. The
     * CLI or SDK generates a random UUID for you and includes that in the request. If you don't use the SDK and instead
     * generate a raw HTTP request to the Secrets Manager service endpoint, then you must generate a
     * <code>ClientRequestToken</code> yourself for new versions and include that value in the request.
     * </p>
     * <p>
     * You typically only need to interact with this value if you implement your own retry logic and want to ensure that
     * a given secret is not created twice. We recommend that you generate a <a
     * href="https://wikipedia.org/wiki/Universally_unique_identifier">UUID-type</a> value to ensure uniqueness within
     * the specified secret.
     * </p>
     * <p>
     * Secrets Manager uses this value to prevent the accidental creation of duplicate versions if there are failures
     * and retries during the Lambda rotation function's processing.
     * </p>
     * <ul>
     * <li>
     * <p>
     * If the <code>ClientRequestToken</code> value isn't already associated with a version of the secret then a new
     * version of the secret is created.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a version with this value already exists and that version's <code>SecretString</code> and
     * <code>SecretBinary</code> values are the same as those in the request then the request is ignored (the operation
     * is idempotent).
     * </p>
     * </li>
     * <li>
     * <p>
     * If a version with this value already exists and that version's <code>SecretString</code> and
     * <code>SecretBinary</code> values are different from the request then an error occurs because you cannot modify an
     * existing secret value.
     * </p>
     * </li>
     * </ul>
     * <p>
     * This value becomes the <code>SecretVersionId</code> of the new version.
     * </p>
     * 
     * @return (Optional) If you want to add a new version to the secret, this parameter specifies a unique identifier
     *         for the new version that helps ensure idempotency. </p>
     *         <p>
     *         If you use the AWS CLI or one of the AWS SDK to call this operation, then you can leave this parameter
     *         empty. The CLI or SDK generates a random UUID for you and includes that in the request. If you don't use
     *         the SDK and instead generate a raw HTTP request to the Secrets Manager service endpoint, then you must
     *         generate a <code>ClientRequestToken</code> yourself for new versions and include that value in the
     *         request.
     *         </p>
     *         <p>
     *         You typically only need to interact with this value if you implement your own retry logic and want to
     *         ensure that a given secret is not created twice. We recommend that you generate a <a
     *         href="https://wikipedia.org/wiki/Universally_unique_identifier">UUID-type</a> value to ensure uniqueness
     *         within the specified secret.
     *         </p>
     *         <p>
     *         Secrets Manager uses this value to prevent the accidental creation of duplicate versions if there are
     *         failures and retries during the Lambda rotation function's processing.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         If the <code>ClientRequestToken</code> value isn't already associated with a version of the secret then a
     *         new version of the secret is created.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         If a version with this value already exists and that version's <code>SecretString</code> and
     *         <code>SecretBinary</code> values are the same as those in the request then the request is ignored (the
     *         operation is idempotent).
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         If a version with this value already exists and that version's <code>SecretString</code> and
     *         <code>SecretBinary</code> values are different from the request then an error occurs because you cannot
     *         modify an existing secret value.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         This value becomes the <code>SecretVersionId</code> of the new version.
     */

    public String getClientRequestToken() {
        return this.clientRequestToken;
    }

    /**
     * <p>
     * (Optional) If you want to add a new version to the secret, this parameter specifies a unique identifier for the
     * new version that helps ensure idempotency.
     * </p>
     * <p>
     * If you use the AWS CLI or one of the AWS SDK to call this operation, then you can leave this parameter empty. The
     * CLI or SDK generates a random UUID for you and includes that in the request. If you don't use the SDK and instead
     * generate a raw HTTP request to the Secrets Manager service endpoint, then you must generate a
     * <code>ClientRequestToken</code> yourself for new versions and include that value in the request.
     * </p>
     * <p>
     * You typically only need to interact with this value if you implement your own retry logic and want to ensure that
     * a given secret is not created twice. We recommend that you generate a <a
     * href="https://wikipedia.org/wiki/Universally_unique_identifier">UUID-type</a> value to ensure uniqueness within
     * the specified secret.
     * </p>
     * <p>
     * Secrets Manager uses this value to prevent the accidental creation of duplicate versions if there are failures
     * and retries during the Lambda rotation function's processing.
     * </p>
     * <ul>
     * <li>
     * <p>
     * If the <code>ClientRequestToken</code> value isn't already associated with a version of the secret then a new
     * version of the secret is created.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a version with this value already exists and that version's <code>SecretString</code> and
     * <code>SecretBinary</code> values are the same as those in the request then the request is ignored (the operation
     * is idempotent).
     * </p>
     * </li>
     * <li>
     * <p>
     * If a version with this value already exists and that version's <code>SecretString</code> and
     * <code>SecretBinary</code> values are different from the request then an error occurs because you cannot modify an
     * existing secret value.
     * </p>
     * </li>
     * </ul>
     * <p>
     * This value becomes the <code>SecretVersionId</code> of the new version.
     * </p>
     * 
     * @param clientRequestToken
     *        (Optional) If you want to add a new version to the secret, this parameter specifies a unique identifier
     *        for the new version that helps ensure idempotency. </p>
     *        <p>
     *        If you use the AWS CLI or one of the AWS SDK to call this operation, then you can leave this parameter
     *        empty. The CLI or SDK generates a random UUID for you and includes that in the request. If you don't use
     *        the SDK and instead generate a raw HTTP request to the Secrets Manager service endpoint, then you must
     *        generate a <code>ClientRequestToken</code> yourself for new versions and include that value in the
     *        request.
     *        </p>
     *        <p>
     *        You typically only need to interact with this value if you implement your own retry logic and want to
     *        ensure that a given secret is not created twice. We recommend that you generate a <a
     *        href="https://wikipedia.org/wiki/Universally_unique_identifier">UUID-type</a> value to ensure uniqueness
     *        within the specified secret.
     *        </p>
     *        <p>
     *        Secrets Manager uses this value to prevent the accidental creation of duplicate versions if there are
     *        failures and retries during the Lambda rotation function's processing.
     *        </p>
     *        <ul>
     *        <li>
     *        <p>
     *        If the <code>ClientRequestToken</code> value isn't already associated with a version of the secret then a
     *        new version of the secret is created.
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        If a version with this value already exists and that version's <code>SecretString</code> and
     *        <code>SecretBinary</code> values are the same as those in the request then the request is ignored (the
     *        operation is idempotent).
     *        </p>
     *        </li>
     *        <li>
     *        <p>
     *        If a version with this value already exists and that version's <code>SecretString</code> and
     *        <code>SecretBinary</code> values are different from the request then an error occurs because you cannot
     *        modify an existing secret value.
     *        </p>
     *        </li>
     *        </ul>
     *        <p>
     *        This value becomes the <code>SecretVersionId</code> of the new version.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateSecretRequest withClientRequestToken(String clientRequestToken) {
        setClientRequestToken(clientRequestToken);
        return this;
    }

    /**
     * <p>
     * (Optional) Specifies a user-provided description of the secret.
     * </p>
     * 
     * @param description
     *        (Optional) Specifies a user-provided description of the secret.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * <p>
     * (Optional) Specifies a user-provided description of the secret.
     * </p>
     * 
     * @return (Optional) Specifies a user-provided description of the secret.
     */

    public String getDescription() {
        return this.description;
    }

    /**
     * <p>
     * (Optional) Specifies a user-provided description of the secret.
     * </p>
     * 
     * @param description
     *        (Optional) Specifies a user-provided description of the secret.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateSecretRequest withDescription(String description) {
        setDescription(description);
        return this;
    }

    /**
     * <p>
     * (Optional) Specifies the ARN or alias of the KMS customer master key (CMK) to be used to encrypt the protected
     * text in the versions of this secret.
     * </p>
     * <p>
     * If you don't specify this value, then Secrets Manager defaults to using the default CMK in the account (the one
     * named <code>aws/secretsmanager</code>). If a KMS CMK with that name doesn't exist, then Secrets Manager creates
     * it for you automatically the first time it needs to encrypt a version's <code>Plaintext</code> or
     * <code>PlaintextString</code> fields.
     * </p>
     * <important>
     * <p>
     * You can only use the account's default CMK to encrypt and decrypt if you call this operation using credentials
     * from the same account that owns the secret. If the secret is in a different account, then you must create a
     * custom CMK and provide the ARN in this field.
     * </p>
     * </important>
     * 
     * @param kmsKeyId
     *        (Optional) Specifies the ARN or alias of the KMS customer master key (CMK) to be used to encrypt the
     *        protected text in the versions of this secret.</p>
     *        <p>
     *        If you don't specify this value, then Secrets Manager defaults to using the default CMK in the account
     *        (the one named <code>aws/secretsmanager</code>). If a KMS CMK with that name doesn't exist, then Secrets
     *        Manager creates it for you automatically the first time it needs to encrypt a version's
     *        <code>Plaintext</code> or <code>PlaintextString</code> fields.
     *        </p>
     *        <important>
     *        <p>
     *        You can only use the account's default CMK to encrypt and decrypt if you call this operation using
     *        credentials from the same account that owns the secret. If the secret is in a different account, then you
     *        must create a custom CMK and provide the ARN in this field.
     *        </p>
     */

    public void setKmsKeyId(String kmsKeyId) {
        this.kmsKeyId = kmsKeyId;
    }

    /**
     * <p>
     * (Optional) Specifies the ARN or alias of the KMS customer master key (CMK) to be used to encrypt the protected
     * text in the versions of this secret.
     * </p>
     * <p>
     * If you don't specify this value, then Secrets Manager defaults to using the default CMK in the account (the one
     * named <code>aws/secretsmanager</code>). If a KMS CMK with that name doesn't exist, then Secrets Manager creates
     * it for you automatically the first time it needs to encrypt a version's <code>Plaintext</code> or
     * <code>PlaintextString</code> fields.
     * </p>
     * <important>
     * <p>
     * You can only use the account's default CMK to encrypt and decrypt if you call this operation using credentials
     * from the same account that owns the secret. If the secret is in a different account, then you must create a
     * custom CMK and provide the ARN in this field.
     * </p>
     * </important>
     * 
     * @return (Optional) Specifies the ARN or alias of the KMS customer master key (CMK) to be used to encrypt the
     *         protected text in the versions of this secret.</p>
     *         <p>
     *         If you don't specify this value, then Secrets Manager defaults to using the default CMK in the account
     *         (the one named <code>aws/secretsmanager</code>). If a KMS CMK with that name doesn't exist, then Secrets
     *         Manager creates it for you automatically the first time it needs to encrypt a version's
     *         <code>Plaintext</code> or <code>PlaintextString</code> fields.
     *         </p>
     *         <important>
     *         <p>
     *         You can only use the account's default CMK to encrypt and decrypt if you call this operation using
     *         credentials from the same account that owns the secret. If the secret is in a different account, then you
     *         must create a custom CMK and provide the ARN in this field.
     *         </p>
     */

    public String getKmsKeyId() {
        return this.kmsKeyId;
    }

    /**
     * <p>
     * (Optional) Specifies the ARN or alias of the KMS customer master key (CMK) to be used to encrypt the protected
     * text in the versions of this secret.
     * </p>
     * <p>
     * If you don't specify this value, then Secrets Manager defaults to using the default CMK in the account (the one
     * named <code>aws/secretsmanager</code>). If a KMS CMK with that name doesn't exist, then Secrets Manager creates
     * it for you automatically the first time it needs to encrypt a version's <code>Plaintext</code> or
     * <code>PlaintextString</code> fields.
     * </p>
     * <important>
     * <p>
     * You can only use the account's default CMK to encrypt and decrypt if you call this operation using credentials
     * from the same account that owns the secret. If the secret is in a different account, then you must create a
     * custom CMK and provide the ARN in this field.
     * </p>
     * </important>
     * 
     * @param kmsKeyId
     *        (Optional) Specifies the ARN or alias of the KMS customer master key (CMK) to be used to encrypt the
     *        protected text in the versions of this secret.</p>
     *        <p>
     *        If you don't specify this value, then Secrets Manager defaults to using the default CMK in the account
     *        (the one named <code>aws/secretsmanager</code>). If a KMS CMK with that name doesn't exist, then Secrets
     *        Manager creates it for you automatically the first time it needs to encrypt a version's
     *        <code>Plaintext</code> or <code>PlaintextString</code> fields.
     *        </p>
     *        <important>
     *        <p>
     *        You can only use the account's default CMK to encrypt and decrypt if you call this operation using
     *        credentials from the same account that owns the secret. If the secret is in a different account, then you
     *        must create a custom CMK and provide the ARN in this field.
     *        </p>
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateSecretRequest withKmsKeyId(String kmsKeyId) {
        setKmsKeyId(kmsKeyId);
        return this;
    }

    /**
     * <p>
     * (Optional) Specifies binary data that you want to encrypt and store in the new version of the secret. To use this
     * parameter in the command-line tools, we recommend that you store your binary data in a file and then use the
     * appropriate technique for your tool to pass the contents of the file as a parameter. Either
     * <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot both be
     * empty.
     * </p>
     * <p>
     * This parameter is not accessible using the Secrets Manager console.
     * </p>
     * <p>
     * The AWS SDK for Java performs a Base64 encoding on this field before sending this request to the AWS service.
     * Users of the SDK should not perform Base64 encoding on this field.
     * </p>
     * <p>
     * Warning: ByteBuffers returned by the SDK are mutable. Changes to the content or position of the byte buffer will
     * be seen by all objects that have a reference to this object. It is recommended to call ByteBuffer.duplicate() or
     * ByteBuffer.asReadOnlyBuffer() before using or reading from the buffer. This behavior will be changed in a future
     * major version of the SDK.
     * </p>
     * 
     * @param secretBinary
     *        (Optional) Specifies binary data that you want to encrypt and store in the new version of the secret. To
     *        use this parameter in the command-line tools, we recommend that you store your binary data in a file and
     *        then use the appropriate technique for your tool to pass the contents of the file as a parameter. Either
     *        <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot both
     *        be empty.</p>
     *        <p>
     *        This parameter is not accessible using the Secrets Manager console.
     */

    public void setSecretBinary(java.nio.ByteBuffer secretBinary) {
        this.secretBinary = secretBinary;
    }

    /**
     * <p>
     * (Optional) Specifies binary data that you want to encrypt and store in the new version of the secret. To use this
     * parameter in the command-line tools, we recommend that you store your binary data in a file and then use the
     * appropriate technique for your tool to pass the contents of the file as a parameter. Either
     * <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot both be
     * empty.
     * </p>
     * <p>
     * This parameter is not accessible using the Secrets Manager console.
     * </p>
     * <p>
     * {@code ByteBuffer}s are stateful. Calling their {@code get} methods changes their {@code position}. We recommend
     * using {@link java.nio.ByteBuffer#asReadOnlyBuffer()} to create a read-only view of the buffer with an independent
     * {@code position}, and calling {@code get} methods on this rather than directly on the returned {@code ByteBuffer}.
     * Doing so will ensure that anyone else using the {@code ByteBuffer} will not be affected by changes to the
     * {@code position}.
     * </p>
     * 
     * @return (Optional) Specifies binary data that you want to encrypt and store in the new version of the secret. To
     *         use this parameter in the command-line tools, we recommend that you store your binary data in a file and
     *         then use the appropriate technique for your tool to pass the contents of the file as a parameter. Either
     *         <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot both
     *         be empty.</p>
     *         <p>
     *         This parameter is not accessible using the Secrets Manager console.
     */

    public java.nio.ByteBuffer getSecretBinary() {
        return this.secretBinary;
    }

    /**
     * <p>
     * (Optional) Specifies binary data that you want to encrypt and store in the new version of the secret. To use this
     * parameter in the command-line tools, we recommend that you store your binary data in a file and then use the
     * appropriate technique for your tool to pass the contents of the file as a parameter. Either
     * <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot both be
     * empty.
     * </p>
     * <p>
     * This parameter is not accessible using the Secrets Manager console.
     * </p>
     * <p>
     * The AWS SDK for Java performs a Base64 encoding on this field before sending this request to the AWS service.
     * Users of the SDK should not perform Base64 encoding on this field.
     * </p>
     * <p>
     * Warning: ByteBuffers returned by the SDK are mutable. Changes to the content or position of the byte buffer will
     * be seen by all objects that have a reference to this object. It is recommended to call ByteBuffer.duplicate() or
     * ByteBuffer.asReadOnlyBuffer() before using or reading from the buffer. This behavior will be changed in a future
     * major version of the SDK.
     * </p>
     * 
     * @param secretBinary
     *        (Optional) Specifies binary data that you want to encrypt and store in the new version of the secret. To
     *        use this parameter in the command-line tools, we recommend that you store your binary data in a file and
     *        then use the appropriate technique for your tool to pass the contents of the file as a parameter. Either
     *        <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot both
     *        be empty.</p>
     *        <p>
     *        This parameter is not accessible using the Secrets Manager console.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateSecretRequest withSecretBinary(java.nio.ByteBuffer secretBinary) {
        setSecretBinary(secretBinary);
        return this;
    }

    /**
     * <p>
     * (Optional) Specifies text data that you want to encrypt and store in this new version of the secret. Either
     * <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot both be
     * empty.
     * </p>
     * <p>
     * If you create this secret by using the Secrets Manager console then Secrets Manager puts the protected secret
     * text in only the <code>SecretString</code> parameter. The Secrets Manager console stores the information as a
     * JSON structure of key/value pairs that the default Lambda rotation function knows how to parse.
     * </p>
     * <p>
     * For storing multiple values, we recommend that you use a JSON text string argument and specify key/value pairs.
     * For information on how to format a JSON parameter for the various command line tool environments, see <a
     * href="http://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html#cli-using-param-json">Using JSON for
     * Parameters</a> in the <i>AWS CLI User Guide</i>.
     * </p>
     * 
     * @param secretString
     *        (Optional) Specifies text data that you want to encrypt and store in this new version of the secret.
     *        Either <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot
     *        both be empty.</p>
     *        <p>
     *        If you create this secret by using the Secrets Manager console then Secrets Manager puts the protected
     *        secret text in only the <code>SecretString</code> parameter. The Secrets Manager console stores the
     *        information as a JSON structure of key/value pairs that the default Lambda rotation function knows how to
     *        parse.
     *        </p>
     *        <p>
     *        For storing multiple values, we recommend that you use a JSON text string argument and specify key/value
     *        pairs. For information on how to format a JSON parameter for the various command line tool environments,
     *        see <a
     *        href="http://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html#cli-using-param-json">Using
     *        JSON for Parameters</a> in the <i>AWS CLI User Guide</i>.
     */

    public void setSecretString(String secretString) {
        this.secretString = secretString;
    }

    /**
     * <p>
     * (Optional) Specifies text data that you want to encrypt and store in this new version of the secret. Either
     * <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot both be
     * empty.
     * </p>
     * <p>
     * If you create this secret by using the Secrets Manager console then Secrets Manager puts the protected secret
     * text in only the <code>SecretString</code> parameter. The Secrets Manager console stores the information as a
     * JSON structure of key/value pairs that the default Lambda rotation function knows how to parse.
     * </p>
     * <p>
     * For storing multiple values, we recommend that you use a JSON text string argument and specify key/value pairs.
     * For information on how to format a JSON parameter for the various command line tool environments, see <a
     * href="http://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html#cli-using-param-json">Using JSON for
     * Parameters</a> in the <i>AWS CLI User Guide</i>.
     * </p>
     * 
     * @return (Optional) Specifies text data that you want to encrypt and store in this new version of the secret.
     *         Either <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They
     *         cannot both be empty.</p>
     *         <p>
     *         If you create this secret by using the Secrets Manager console then Secrets Manager puts the protected
     *         secret text in only the <code>SecretString</code> parameter. The Secrets Manager console stores the
     *         information as a JSON structure of key/value pairs that the default Lambda rotation function knows how to
     *         parse.
     *         </p>
     *         <p>
     *         For storing multiple values, we recommend that you use a JSON text string argument and specify key/value
     *         pairs. For information on how to format a JSON parameter for the various command line tool environments,
     *         see <a
     *         href="http://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html#cli-using-param-json">Using
     *         JSON for Parameters</a> in the <i>AWS CLI User Guide</i>.
     */

    public String getSecretString() {
        return this.secretString;
    }

    /**
     * <p>
     * (Optional) Specifies text data that you want to encrypt and store in this new version of the secret. Either
     * <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot both be
     * empty.
     * </p>
     * <p>
     * If you create this secret by using the Secrets Manager console then Secrets Manager puts the protected secret
     * text in only the <code>SecretString</code> parameter. The Secrets Manager console stores the information as a
     * JSON structure of key/value pairs that the default Lambda rotation function knows how to parse.
     * </p>
     * <p>
     * For storing multiple values, we recommend that you use a JSON text string argument and specify key/value pairs.
     * For information on how to format a JSON parameter for the various command line tool environments, see <a
     * href="http://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html#cli-using-param-json">Using JSON for
     * Parameters</a> in the <i>AWS CLI User Guide</i>.
     * </p>
     * 
     * @param secretString
     *        (Optional) Specifies text data that you want to encrypt and store in this new version of the secret.
     *        Either <code>SecretBinary</code> or <code>SecretString</code> must have a value, but not both. They cannot
     *        both be empty.</p>
     *        <p>
     *        If you create this secret by using the Secrets Manager console then Secrets Manager puts the protected
     *        secret text in only the <code>SecretString</code> parameter. The Secrets Manager console stores the
     *        information as a JSON structure of key/value pairs that the default Lambda rotation function knows how to
     *        parse.
     *        </p>
     *        <p>
     *        For storing multiple values, we recommend that you use a JSON text string argument and specify key/value
     *        pairs. For information on how to format a JSON parameter for the various command line tool environments,
     *        see <a
     *        href="http://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html#cli-using-param-json">Using
     *        JSON for Parameters</a> in the <i>AWS CLI User Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateSecretRequest withSecretString(String secretString) {
        setSecretString(secretString);
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSecretId() != null)
            sb.append("SecretId: ").append(getSecretId()).append(",");
        if (getClientRequestToken() != null)
            sb.append("ClientRequestToken: ").append(getClientRequestToken()).append(",");
        if (getDescription() != null)
            sb.append("Description: ").append(getDescription()).append(",");
        if (getKmsKeyId() != null)
            sb.append("KmsKeyId: ").append(getKmsKeyId()).append(",");
        if (getSecretBinary() != null)
            sb.append("SecretBinary: ").append(getSecretBinary()).append(",");
        if (getSecretString() != null)
            sb.append("SecretString: ").append(getSecretString());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof UpdateSecretRequest == false)
            return false;
        UpdateSecretRequest other = (UpdateSecretRequest) obj;
        if (other.getSecretId() == null ^ this.getSecretId() == null)
            return false;
        if (other.getSecretId() != null && other.getSecretId().equals(this.getSecretId()) == false)
            return false;
        if (other.getClientRequestToken() == null ^ this.getClientRequestToken() == null)
            return false;
        if (other.getClientRequestToken() != null && other.getClientRequestToken().equals(this.getClientRequestToken()) == false)
            return false;
        if (other.getDescription() == null ^ this.getDescription() == null)
            return false;
        if (other.getDescription() != null && other.getDescription().equals(this.getDescription()) == false)
            return false;
        if (other.getKmsKeyId() == null ^ this.getKmsKeyId() == null)
            return false;
        if (other.getKmsKeyId() != null && other.getKmsKeyId().equals(this.getKmsKeyId()) == false)
            return false;
        if (other.getSecretBinary() == null ^ this.getSecretBinary() == null)
            return false;
        if (other.getSecretBinary() != null && other.getSecretBinary().equals(this.getSecretBinary()) == false)
            return false;
        if (other.getSecretString() == null ^ this.getSecretString() == null)
            return false;
        if (other.getSecretString() != null && other.getSecretString().equals(this.getSecretString()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getSecretId() == null) ? 0 : getSecretId().hashCode());
        hashCode = prime * hashCode + ((getClientRequestToken() == null) ? 0 : getClientRequestToken().hashCode());
        hashCode = prime * hashCode + ((getDescription() == null) ? 0 : getDescription().hashCode());
        hashCode = prime * hashCode + ((getKmsKeyId() == null) ? 0 : getKmsKeyId().hashCode());
        hashCode = prime * hashCode + ((getSecretBinary() == null) ? 0 : getSecretBinary().hashCode());
        hashCode = prime * hashCode + ((getSecretString() == null) ? 0 : getSecretString().hashCode());
        return hashCode;
    }

    @Override
    public UpdateSecretRequest clone() {
        return (UpdateSecretRequest) super.clone();
    }

}
