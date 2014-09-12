package net.minecraft.server;

public class ReportedException extends RuntimeException {

   private final CrashReport a;


   public ReportedException(CrashReport var1) {
      this.a = var1;
   }

   public CrashReport a() {
      return this.a;
   }

   public Throwable getCause() {
      return this.a.b();
   }

   public String getMessage() {
      return this.a.a();
   }
}
