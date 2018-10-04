package com.gpetuhov.android.sampletoothpick;

import com.gpetuhov.android.sampletoothpick.car.Jeep;
import com.gpetuhov.android.sampletoothpick.engine.Engine;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.inject.Inject;

import toothpick.testing.ToothPickRule;

import static org.junit.Assert.assertEquals;

public class JeepTest2 {
  @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
  @Rule public ToothPickRule toothPickRule = new ToothPickRule(this, "Jeep");

  @Mock Engine engine;

  @Inject Jeep jeep;

  @Before
  public void setUp() {
    toothPickRule.inject(this);
  }

  @Test
  public void checkEngine() {
    Mockito.when(engine.getType()).thenReturn("Gas");
    assertEquals("Gas", jeep.getEngineType());
  }
}
