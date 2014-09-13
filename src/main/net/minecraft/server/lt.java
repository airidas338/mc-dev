package net.minecraft.server;
import org.apache.commons.lang3.StringUtils;

public class lt implements Packet {

   private String a;
   private Location b;


   public lt() {}

   public lt(String var1) {
      this(var1, (Location)null);
   }

   public lt(String var1, Location var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(hd var1) {
      this.a = var1.c(32767);
      boolean var2 = var1.readBoolean();
      if(var2) {
         this.b = var1.c();
      }

   }

   public void b(hd var1) {
      var1.a(StringUtils.substring(this.a, 0, 32767));
      boolean var2 = this.b != null;
      var1.writeBoolean(var2);
      if(var2) {
         var1.a(this.b);
      }

   }

   public void a(PacketListener var1) {
      ((ls)var1).a(this);
   }

   public String a() {
      return this.a;
   }

   public Location b() {
      return this.b;
   }
}
