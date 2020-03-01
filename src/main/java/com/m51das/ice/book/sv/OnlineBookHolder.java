// **********************************************************************
//
// Copyright (c) 2003-2018 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.5
//
// <auto-generated>
//
// Generated from file `bookservice.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.m51das.ice.book.sv;

public final class OnlineBookHolder extends Ice.ObjectHolderBase<OnlineBook>
{
    public
    OnlineBookHolder()
    {
    }

    public
    OnlineBookHolder(OnlineBook value)
    {
        this.value = value;
    }

    public void
    patch(Ice.Object v)
    {
        if(v == null || v instanceof OnlineBook)
        {
            value = (OnlineBook)v;
        }
        else
        {
            IceInternal.Ex.throwUOE(type(), v);
        }
    }

    public String
    type()
    {
        return _OnlineBookDisp.ice_staticId();
    }
}
