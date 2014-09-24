package net.minecraft.server;


class aei extends MobSpawnerAbstract {

   // $FF: synthetic field
   final EntityMinecartMobSpawner a;


   aei(EntityMinecartMobSpawner var1) {
      this.a = var1;
   }

   public void a(int var1) {
      this.a.o.broadcastEntityEffect((Entity)this.a, (byte)var1);
   }

   public World a() {
      return this.a.o;
   }

   public Location b() {
      return new Location(this.a);
   }
}
