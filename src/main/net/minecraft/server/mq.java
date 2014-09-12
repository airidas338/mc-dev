package net.minecraft.server;

public class mq implements id {

   private String a;
   private mr b;


   public void a(hd var1) {
      this.a = var1.c(40);
      this.b = (mr)var1.a(mr.class);
   }

   public void b(hd var1) {
      var1.a(this.a);
      var1.a((Enum)this.b);
   }

   public void a(PacketListener var1) {
      ((ls)var1).a(this);
   }
}
