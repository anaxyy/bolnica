package com.fit.djecijaBolnica.pages;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;

/**
 * Start page of application djecijaBolnica.
 */

// ogranicavanje koje role mogu da pristupe ovoj stranici
@RequiresRoles(value = { "DOKTOR", "ADMIN" }, logical = Logical.OR)
public class Doktor {

}
