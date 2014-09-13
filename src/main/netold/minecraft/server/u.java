package net.minecraft.server;

public class u extends RuntimeException {

   private final bRenamed a;


   public u(bRenamed var1) {
      this.a = var1;
   }

   public bRenamed a() {
      return this.a;
   }

   public Throwable getCause() {
      return this.a.b();
   }

   public String getMessage() {
      return this.a.a();
   }
}
