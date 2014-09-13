package net.minecraft.server;
import java.io.IOException;
import java.util.List;

public class kx implements Packet {

   private int a;
   private List b;


   public kx() {}

   public kx(int var1, DataWatcher var2, boolean var3) {
      this.a = var1;
      if(var3) {
         this.b = var2.c();
      } else {
         this.b = var2.b();
      }

   }

   public void a(hd var1) throws IOException {
      this.a = var1.e();
      this.b = DataWatcher.b(var1);
   }

   public void b(hd var1) throws IOException {
      var1.b(this.a);
      DataWatcher.a(this.b, var1);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
