package net.minecraft.server;
import java.io.IOException;


public class jl implements id {

   private int a;
   private fn b;


   public jl() {}

   public jl(int var1, fn var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(hd var1) throws IOException {
      this.a = var1.e();
      this.b = var1.h();
   }

   public void b(hd var1) throws IOException {
      var1.b(this.a);
      var1.a(this.b);
   }

   public void a(PacketListener var1) {
      ((ik)var1).a(this);
   }
}
