package net.minecraft.server;
import java.io.IOException;


public class md implements Packet {

   private int a;
   private me b;
   private ChunkCoordinates c;


   public void a(hd var1) {
      this.a = var1.e();
      this.b = (me)var1.a(me.class);
      if(this.b == me.c) {
         this.c = new ChunkCoordinates((double)var1.readFloat(), (double)var1.readFloat(), (double)var1.readFloat());
      }

   }

   public void b(hd var1) {
      var1.b(this.a);
      var1.a((Enum)this.b);
      if(this.b == me.c) {
         var1.writeFloat((float)this.c.a);
         var1.writeFloat((float)this.c.b);
         var1.writeFloat((float)this.c.c);
      }

   }

   public void a(PacketListener var1) throws IOException {
      ((ls)var1).a(this);
   }

   public Entity a(World var1) {
      return var1.a(this.a);
   }

   public me a() {
      return this.b;
   }

   public ChunkCoordinates b() {
      return this.c;
   }
}
