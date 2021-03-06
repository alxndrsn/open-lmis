/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2013 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License along with this program.  If not, see http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org. 
 */

package org.openlmis.web.controller;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openlmis.core.domain.DosageUnit;
import org.openlmis.core.domain.ProductForm;
import org.openlmis.core.domain.ProductGroup;
import org.openlmis.core.service.ProductFormService;
import org.openlmis.core.service.ProductGroupService;
import org.openlmis.core.service.ProductService;
import org.openlmis.db.categories.UnitTests;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@Category(UnitTests.class)
@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

  @Mock
  ProductGroupService groupService;

  @Mock
  ProductFormService formService;

  @Mock
  ProductService service;

  @InjectMocks
  ProductController controller;

  @Test
  public void shouldGetAllProductGroups() throws Exception {
    List<ProductGroup> groups = new ArrayList<>();
    when(groupService.getAll()).thenReturn(groups);

    List<ProductGroup> productGroups = controller.getAllGroups();

    assertThat(productGroups, is(groups));
  }

  @Test
  public void shouldGetAllProductForms() throws Exception {
    List<ProductForm> forms = new ArrayList<>();
    when(formService.getAll()).thenReturn(forms);

    List<ProductForm> productForms = controller.getAllForms();

    assertThat(productForms, is(forms));
  }

  @Test
  public void shouldGetAllDosageUnits() throws Exception {
    List<DosageUnit> dosageUnits = new ArrayList<>();
    when(service.getAllDosageUnits()).thenReturn(dosageUnits);

    List<DosageUnit> result = controller.getAllDosageUnits();

    assertThat(result, is(dosageUnits));
  }
}
