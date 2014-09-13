package net.minecraft.server;

import java.util.Collection;
import java.util.UUID;

public interface AttributeInstance {

   IAttribute a();

   double b();

   void a(double var1);

   Collection a(int var1);

   Collection c();

   boolean a(AttributeModifier var1);

   AttributeModifier a(UUID var1);

   void b(AttributeModifier var1);

   void c(AttributeModifier var1);

   double getValue();
}
