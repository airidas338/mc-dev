package net.minecraft.server;
import java.io.IOException;


public class mt implements id {

   private int a;
   private amj b;


   public void a(PacketListener var1) {
      ((ls)var1).a(this);
   }

   public void a(hd var1) throws IOException {
      this.a = var1.readShort();
      this.b = var1.i();
   }

   public void b(hd var1) throws IOException {
      var1.writeShort(this.a);
      var1.a(this.b);
   }

   public int a() {
      return this.a;
   }

   public amj b() {
      return this.b;
   }
}
