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
package com.amazonaws.services.codeguruprofiler.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.amazonaws.protocol.StructuredPojo;
import com.amazonaws.protocol.ProtocolMarshaller;

/**
 * <p/>
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/codeguruprofiler-2019-07-18/AgentConfiguration"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class AgentConfiguration implements Serializable, Cloneable, StructuredPojo {

    /** <p/> */
    private Integer periodInSeconds;
    /** <p/> */
    private Boolean shouldProfile;

    /**
     * <p/>
     * 
     * @param periodInSeconds
     */

    public void setPeriodInSeconds(Integer periodInSeconds) {
        this.periodInSeconds = periodInSeconds;
    }

    /**
     * <p/>
     * 
     * @return
     */

    public Integer getPeriodInSeconds() {
        return this.periodInSeconds;
    }

    /**
     * <p/>
     * 
     * @param periodInSeconds
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AgentConfiguration withPeriodInSeconds(Integer periodInSeconds) {
        setPeriodInSeconds(periodInSeconds);
        return this;
    }

    /**
     * <p/>
     * 
     * @param shouldProfile
     */

    public void setShouldProfile(Boolean shouldProfile) {
        this.shouldProfile = shouldProfile;
    }

    /**
     * <p/>
     * 
     * @return
     */

    public Boolean getShouldProfile() {
        return this.shouldProfile;
    }

    /**
     * <p/>
     * 
     * @param shouldProfile
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AgentConfiguration withShouldProfile(Boolean shouldProfile) {
        setShouldProfile(shouldProfile);
        return this;
    }

    /**
     * <p/>
     * 
     * @return
     */

    public Boolean isShouldProfile() {
        return this.shouldProfile;
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
        if (getPeriodInSeconds() != null)
            sb.append("PeriodInSeconds: ").append(getPeriodInSeconds()).append(",");
        if (getShouldProfile() != null)
            sb.append("ShouldProfile: ").append(getShouldProfile());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof AgentConfiguration == false)
            return false;
        AgentConfiguration other = (AgentConfiguration) obj;
        if (other.getPeriodInSeconds() == null ^ this.getPeriodInSeconds() == null)
            return false;
        if (other.getPeriodInSeconds() != null && other.getPeriodInSeconds().equals(this.getPeriodInSeconds()) == false)
            return false;
        if (other.getShouldProfile() == null ^ this.getShouldProfile() == null)
            return false;
        if (other.getShouldProfile() != null && other.getShouldProfile().equals(this.getShouldProfile()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getPeriodInSeconds() == null) ? 0 : getPeriodInSeconds().hashCode());
        hashCode = prime * hashCode + ((getShouldProfile() == null) ? 0 : getShouldProfile().hashCode());
        return hashCode;
    }

    @Override
    public AgentConfiguration clone() {
        try {
            return (AgentConfiguration) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.amazonaws.services.codeguruprofiler.model.transform.AgentConfigurationMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
