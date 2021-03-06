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
package com.amazonaws.services.kinesisfirehose.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.amazonaws.protocol.StructuredPojo;
import com.amazonaws.protocol.ProtocolMarshaller;

/**
 * <p>
 * The details of the VPC of the Amazon ES destination.
 * </p>
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/firehose-2015-08-04/VpcConfigurationDescription"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class VpcConfigurationDescription implements Serializable, Cloneable, StructuredPojo {

    /**
     * <p>
     * The IDs of the subnets that Kinesis Data Firehose uses to create ENIs in the VPC of the Amazon ES destination.
     * Make sure that the routing tables and inbound and outbound rules allow traffic to flow from the subnets whose IDs
     * are specified here to the subnets that have the destination Amazon ES endpoints. Kinesis Data Firehose creates at
     * least one ENI in each of the subnets that are specified here. Do not delete or modify these ENIs.
     * </p>
     * <p>
     * The number of ENIs that Kinesis Data Firehose creates in the subnets specified here scales up and down
     * automatically based on throughput. To enable Kinesis Data Firehose to scale up the number of ENIs to match
     * throughput, ensure that you have sufficient quota. To help you calculate the quota you need, assume that Kinesis
     * Data Firehose can create up to three ENIs for this delivery stream for each of the subnets specified here. For
     * more information about ENI quota, see <a
     * href="https://docs.aws.amazon.com/vpc/latest/userguide/amazon-vpc-limits.html#vpc-limits-enis">Network Interfaces
     * </a> in the Amazon VPC Quotas topic.
     * </p>
     */
    private java.util.List<String> subnetIds;
    /**
     * <p>
     * The ARN of the IAM role that you want the delivery stream uses to create endpoints in the destination VPC.
     * </p>
     */
    private String roleARN;
    /**
     * <p>
     * The IDs of the security groups that Kinesis Data Firehose uses when it creates ENIs in the VPC of the Amazon ES
     * destination.
     * </p>
     */
    private java.util.List<String> securityGroupIds;
    /**
     * <p>
     * The ID of the Amazon ES destination's VPC.
     * </p>
     */
    private String vpcId;

    /**
     * <p>
     * The IDs of the subnets that Kinesis Data Firehose uses to create ENIs in the VPC of the Amazon ES destination.
     * Make sure that the routing tables and inbound and outbound rules allow traffic to flow from the subnets whose IDs
     * are specified here to the subnets that have the destination Amazon ES endpoints. Kinesis Data Firehose creates at
     * least one ENI in each of the subnets that are specified here. Do not delete or modify these ENIs.
     * </p>
     * <p>
     * The number of ENIs that Kinesis Data Firehose creates in the subnets specified here scales up and down
     * automatically based on throughput. To enable Kinesis Data Firehose to scale up the number of ENIs to match
     * throughput, ensure that you have sufficient quota. To help you calculate the quota you need, assume that Kinesis
     * Data Firehose can create up to three ENIs for this delivery stream for each of the subnets specified here. For
     * more information about ENI quota, see <a
     * href="https://docs.aws.amazon.com/vpc/latest/userguide/amazon-vpc-limits.html#vpc-limits-enis">Network Interfaces
     * </a> in the Amazon VPC Quotas topic.
     * </p>
     * 
     * @return The IDs of the subnets that Kinesis Data Firehose uses to create ENIs in the VPC of the Amazon ES
     *         destination. Make sure that the routing tables and inbound and outbound rules allow traffic to flow from
     *         the subnets whose IDs are specified here to the subnets that have the destination Amazon ES endpoints.
     *         Kinesis Data Firehose creates at least one ENI in each of the subnets that are specified here. Do not
     *         delete or modify these ENIs.</p>
     *         <p>
     *         The number of ENIs that Kinesis Data Firehose creates in the subnets specified here scales up and down
     *         automatically based on throughput. To enable Kinesis Data Firehose to scale up the number of ENIs to
     *         match throughput, ensure that you have sufficient quota. To help you calculate the quota you need, assume
     *         that Kinesis Data Firehose can create up to three ENIs for this delivery stream for each of the subnets
     *         specified here. For more information about ENI quota, see <a
     *         href="https://docs.aws.amazon.com/vpc/latest/userguide/amazon-vpc-limits.html#vpc-limits-enis">Network
     *         Interfaces </a> in the Amazon VPC Quotas topic.
     */

    public java.util.List<String> getSubnetIds() {
        return subnetIds;
    }

    /**
     * <p>
     * The IDs of the subnets that Kinesis Data Firehose uses to create ENIs in the VPC of the Amazon ES destination.
     * Make sure that the routing tables and inbound and outbound rules allow traffic to flow from the subnets whose IDs
     * are specified here to the subnets that have the destination Amazon ES endpoints. Kinesis Data Firehose creates at
     * least one ENI in each of the subnets that are specified here. Do not delete or modify these ENIs.
     * </p>
     * <p>
     * The number of ENIs that Kinesis Data Firehose creates in the subnets specified here scales up and down
     * automatically based on throughput. To enable Kinesis Data Firehose to scale up the number of ENIs to match
     * throughput, ensure that you have sufficient quota. To help you calculate the quota you need, assume that Kinesis
     * Data Firehose can create up to three ENIs for this delivery stream for each of the subnets specified here. For
     * more information about ENI quota, see <a
     * href="https://docs.aws.amazon.com/vpc/latest/userguide/amazon-vpc-limits.html#vpc-limits-enis">Network Interfaces
     * </a> in the Amazon VPC Quotas topic.
     * </p>
     * 
     * @param subnetIds
     *        The IDs of the subnets that Kinesis Data Firehose uses to create ENIs in the VPC of the Amazon ES
     *        destination. Make sure that the routing tables and inbound and outbound rules allow traffic to flow from
     *        the subnets whose IDs are specified here to the subnets that have the destination Amazon ES endpoints.
     *        Kinesis Data Firehose creates at least one ENI in each of the subnets that are specified here. Do not
     *        delete or modify these ENIs.</p>
     *        <p>
     *        The number of ENIs that Kinesis Data Firehose creates in the subnets specified here scales up and down
     *        automatically based on throughput. To enable Kinesis Data Firehose to scale up the number of ENIs to match
     *        throughput, ensure that you have sufficient quota. To help you calculate the quota you need, assume that
     *        Kinesis Data Firehose can create up to three ENIs for this delivery stream for each of the subnets
     *        specified here. For more information about ENI quota, see <a
     *        href="https://docs.aws.amazon.com/vpc/latest/userguide/amazon-vpc-limits.html#vpc-limits-enis">Network
     *        Interfaces </a> in the Amazon VPC Quotas topic.
     */

    public void setSubnetIds(java.util.Collection<String> subnetIds) {
        if (subnetIds == null) {
            this.subnetIds = null;
            return;
        }

        this.subnetIds = new java.util.ArrayList<String>(subnetIds);
    }

    /**
     * <p>
     * The IDs of the subnets that Kinesis Data Firehose uses to create ENIs in the VPC of the Amazon ES destination.
     * Make sure that the routing tables and inbound and outbound rules allow traffic to flow from the subnets whose IDs
     * are specified here to the subnets that have the destination Amazon ES endpoints. Kinesis Data Firehose creates at
     * least one ENI in each of the subnets that are specified here. Do not delete or modify these ENIs.
     * </p>
     * <p>
     * The number of ENIs that Kinesis Data Firehose creates in the subnets specified here scales up and down
     * automatically based on throughput. To enable Kinesis Data Firehose to scale up the number of ENIs to match
     * throughput, ensure that you have sufficient quota. To help you calculate the quota you need, assume that Kinesis
     * Data Firehose can create up to three ENIs for this delivery stream for each of the subnets specified here. For
     * more information about ENI quota, see <a
     * href="https://docs.aws.amazon.com/vpc/latest/userguide/amazon-vpc-limits.html#vpc-limits-enis">Network Interfaces
     * </a> in the Amazon VPC Quotas topic.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setSubnetIds(java.util.Collection)} or {@link #withSubnetIds(java.util.Collection)} if you want to
     * override the existing values.
     * </p>
     * 
     * @param subnetIds
     *        The IDs of the subnets that Kinesis Data Firehose uses to create ENIs in the VPC of the Amazon ES
     *        destination. Make sure that the routing tables and inbound and outbound rules allow traffic to flow from
     *        the subnets whose IDs are specified here to the subnets that have the destination Amazon ES endpoints.
     *        Kinesis Data Firehose creates at least one ENI in each of the subnets that are specified here. Do not
     *        delete or modify these ENIs.</p>
     *        <p>
     *        The number of ENIs that Kinesis Data Firehose creates in the subnets specified here scales up and down
     *        automatically based on throughput. To enable Kinesis Data Firehose to scale up the number of ENIs to match
     *        throughput, ensure that you have sufficient quota. To help you calculate the quota you need, assume that
     *        Kinesis Data Firehose can create up to three ENIs for this delivery stream for each of the subnets
     *        specified here. For more information about ENI quota, see <a
     *        href="https://docs.aws.amazon.com/vpc/latest/userguide/amazon-vpc-limits.html#vpc-limits-enis">Network
     *        Interfaces </a> in the Amazon VPC Quotas topic.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public VpcConfigurationDescription withSubnetIds(String... subnetIds) {
        if (this.subnetIds == null) {
            setSubnetIds(new java.util.ArrayList<String>(subnetIds.length));
        }
        for (String ele : subnetIds) {
            this.subnetIds.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * The IDs of the subnets that Kinesis Data Firehose uses to create ENIs in the VPC of the Amazon ES destination.
     * Make sure that the routing tables and inbound and outbound rules allow traffic to flow from the subnets whose IDs
     * are specified here to the subnets that have the destination Amazon ES endpoints. Kinesis Data Firehose creates at
     * least one ENI in each of the subnets that are specified here. Do not delete or modify these ENIs.
     * </p>
     * <p>
     * The number of ENIs that Kinesis Data Firehose creates in the subnets specified here scales up and down
     * automatically based on throughput. To enable Kinesis Data Firehose to scale up the number of ENIs to match
     * throughput, ensure that you have sufficient quota. To help you calculate the quota you need, assume that Kinesis
     * Data Firehose can create up to three ENIs for this delivery stream for each of the subnets specified here. For
     * more information about ENI quota, see <a
     * href="https://docs.aws.amazon.com/vpc/latest/userguide/amazon-vpc-limits.html#vpc-limits-enis">Network Interfaces
     * </a> in the Amazon VPC Quotas topic.
     * </p>
     * 
     * @param subnetIds
     *        The IDs of the subnets that Kinesis Data Firehose uses to create ENIs in the VPC of the Amazon ES
     *        destination. Make sure that the routing tables and inbound and outbound rules allow traffic to flow from
     *        the subnets whose IDs are specified here to the subnets that have the destination Amazon ES endpoints.
     *        Kinesis Data Firehose creates at least one ENI in each of the subnets that are specified here. Do not
     *        delete or modify these ENIs.</p>
     *        <p>
     *        The number of ENIs that Kinesis Data Firehose creates in the subnets specified here scales up and down
     *        automatically based on throughput. To enable Kinesis Data Firehose to scale up the number of ENIs to match
     *        throughput, ensure that you have sufficient quota. To help you calculate the quota you need, assume that
     *        Kinesis Data Firehose can create up to three ENIs for this delivery stream for each of the subnets
     *        specified here. For more information about ENI quota, see <a
     *        href="https://docs.aws.amazon.com/vpc/latest/userguide/amazon-vpc-limits.html#vpc-limits-enis">Network
     *        Interfaces </a> in the Amazon VPC Quotas topic.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public VpcConfigurationDescription withSubnetIds(java.util.Collection<String> subnetIds) {
        setSubnetIds(subnetIds);
        return this;
    }

    /**
     * <p>
     * The ARN of the IAM role that you want the delivery stream uses to create endpoints in the destination VPC.
     * </p>
     * 
     * @param roleARN
     *        The ARN of the IAM role that you want the delivery stream uses to create endpoints in the destination VPC.
     */

    public void setRoleARN(String roleARN) {
        this.roleARN = roleARN;
    }

    /**
     * <p>
     * The ARN of the IAM role that you want the delivery stream uses to create endpoints in the destination VPC.
     * </p>
     * 
     * @return The ARN of the IAM role that you want the delivery stream uses to create endpoints in the destination
     *         VPC.
     */

    public String getRoleARN() {
        return this.roleARN;
    }

    /**
     * <p>
     * The ARN of the IAM role that you want the delivery stream uses to create endpoints in the destination VPC.
     * </p>
     * 
     * @param roleARN
     *        The ARN of the IAM role that you want the delivery stream uses to create endpoints in the destination VPC.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public VpcConfigurationDescription withRoleARN(String roleARN) {
        setRoleARN(roleARN);
        return this;
    }

    /**
     * <p>
     * The IDs of the security groups that Kinesis Data Firehose uses when it creates ENIs in the VPC of the Amazon ES
     * destination.
     * </p>
     * 
     * @return The IDs of the security groups that Kinesis Data Firehose uses when it creates ENIs in the VPC of the
     *         Amazon ES destination.
     */

    public java.util.List<String> getSecurityGroupIds() {
        return securityGroupIds;
    }

    /**
     * <p>
     * The IDs of the security groups that Kinesis Data Firehose uses when it creates ENIs in the VPC of the Amazon ES
     * destination.
     * </p>
     * 
     * @param securityGroupIds
     *        The IDs of the security groups that Kinesis Data Firehose uses when it creates ENIs in the VPC of the
     *        Amazon ES destination.
     */

    public void setSecurityGroupIds(java.util.Collection<String> securityGroupIds) {
        if (securityGroupIds == null) {
            this.securityGroupIds = null;
            return;
        }

        this.securityGroupIds = new java.util.ArrayList<String>(securityGroupIds);
    }

    /**
     * <p>
     * The IDs of the security groups that Kinesis Data Firehose uses when it creates ENIs in the VPC of the Amazon ES
     * destination.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setSecurityGroupIds(java.util.Collection)} or {@link #withSecurityGroupIds(java.util.Collection)} if you
     * want to override the existing values.
     * </p>
     * 
     * @param securityGroupIds
     *        The IDs of the security groups that Kinesis Data Firehose uses when it creates ENIs in the VPC of the
     *        Amazon ES destination.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public VpcConfigurationDescription withSecurityGroupIds(String... securityGroupIds) {
        if (this.securityGroupIds == null) {
            setSecurityGroupIds(new java.util.ArrayList<String>(securityGroupIds.length));
        }
        for (String ele : securityGroupIds) {
            this.securityGroupIds.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * The IDs of the security groups that Kinesis Data Firehose uses when it creates ENIs in the VPC of the Amazon ES
     * destination.
     * </p>
     * 
     * @param securityGroupIds
     *        The IDs of the security groups that Kinesis Data Firehose uses when it creates ENIs in the VPC of the
     *        Amazon ES destination.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public VpcConfigurationDescription withSecurityGroupIds(java.util.Collection<String> securityGroupIds) {
        setSecurityGroupIds(securityGroupIds);
        return this;
    }

    /**
     * <p>
     * The ID of the Amazon ES destination's VPC.
     * </p>
     * 
     * @param vpcId
     *        The ID of the Amazon ES destination's VPC.
     */

    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

    /**
     * <p>
     * The ID of the Amazon ES destination's VPC.
     * </p>
     * 
     * @return The ID of the Amazon ES destination's VPC.
     */

    public String getVpcId() {
        return this.vpcId;
    }

    /**
     * <p>
     * The ID of the Amazon ES destination's VPC.
     * </p>
     * 
     * @param vpcId
     *        The ID of the Amazon ES destination's VPC.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public VpcConfigurationDescription withVpcId(String vpcId) {
        setVpcId(vpcId);
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
        if (getSubnetIds() != null)
            sb.append("SubnetIds: ").append(getSubnetIds()).append(",");
        if (getRoleARN() != null)
            sb.append("RoleARN: ").append(getRoleARN()).append(",");
        if (getSecurityGroupIds() != null)
            sb.append("SecurityGroupIds: ").append(getSecurityGroupIds()).append(",");
        if (getVpcId() != null)
            sb.append("VpcId: ").append(getVpcId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof VpcConfigurationDescription == false)
            return false;
        VpcConfigurationDescription other = (VpcConfigurationDescription) obj;
        if (other.getSubnetIds() == null ^ this.getSubnetIds() == null)
            return false;
        if (other.getSubnetIds() != null && other.getSubnetIds().equals(this.getSubnetIds()) == false)
            return false;
        if (other.getRoleARN() == null ^ this.getRoleARN() == null)
            return false;
        if (other.getRoleARN() != null && other.getRoleARN().equals(this.getRoleARN()) == false)
            return false;
        if (other.getSecurityGroupIds() == null ^ this.getSecurityGroupIds() == null)
            return false;
        if (other.getSecurityGroupIds() != null && other.getSecurityGroupIds().equals(this.getSecurityGroupIds()) == false)
            return false;
        if (other.getVpcId() == null ^ this.getVpcId() == null)
            return false;
        if (other.getVpcId() != null && other.getVpcId().equals(this.getVpcId()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getSubnetIds() == null) ? 0 : getSubnetIds().hashCode());
        hashCode = prime * hashCode + ((getRoleARN() == null) ? 0 : getRoleARN().hashCode());
        hashCode = prime * hashCode + ((getSecurityGroupIds() == null) ? 0 : getSecurityGroupIds().hashCode());
        hashCode = prime * hashCode + ((getVpcId() == null) ? 0 : getVpcId().hashCode());
        return hashCode;
    }

    @Override
    public VpcConfigurationDescription clone() {
        try {
            return (VpcConfigurationDescription) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.amazonaws.services.kinesisfirehose.model.transform.VpcConfigurationDescriptionMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
