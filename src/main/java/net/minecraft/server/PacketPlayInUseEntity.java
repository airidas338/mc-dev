package net.minecraft.server;
import java.io.IOException;


public class PacketPlayInUseEntity implements Packet {

   private int a;
   private me b;
   private Vec3D c;


   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
      this.b = (me)var1.a(me.class);
      if(this.b == me.c) {
         this.c = new Vec3D((double)var1.readFloat(), (double)var1.readFloat(), (double)var1.readFloat());
      }

   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
      var1.a((Enum)this.b);
      if(this.b == me.c) {
         var1.writeFloat((float)this.c.a);
         var1.writeFloat((float)this.c.b);
         var1.writeFloat((float)this.c.c);
      }

   }

   public void a(PacketListener var1) throws IOException {
      ((PacketPlayInListener)var1).a(this);
   }

   public Entity a(World var1) {
      return var1.getEntity(this.a);
   }

   public me a() {
      return this.b;
   }

   public Vec3D b() {
      return this.c;
   }
}
