package net.minecraft.server;
import java.io.IOException;
import java.util.UUID;

public class mw implements Packet {

   private UUID a;


   public mw() {}

   public mw(UUID var1) {
      this.a = var1;
   }

   public void a(hd var1) {
      this.a = var1.g();
   }

   public void b(hd var1) {
      var1.a(this.a);
   }

   public void a(PacketListener var1) throws IOException {
      ((ls)var1).a(this);
   }

   public Entity a(WorldServer var1) {
      return var1.a(this.a);
   }
}
