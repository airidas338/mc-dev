package net.minecraft.server;

class MobSpawner extends MobSpawnerAbstract {

   // $FF: synthetic field
   final TileEntityMobSpawner a;


   MobSpawner(TileEntityMobSpawner var1) {
      this.a = var1;
   }

   public void a(int var1) {
      this.a.b.playBlockAction(this.a.c, Blocks.MOB_SPAWNER, var1, 0);
   }

   public World a() {
      return this.a.b;
   }

   public Location b() {
      return this.a.c;
   }

   public void a(TileEntityMobSpawnerData var1) {
      super.a(var1);
      if(this.a() != null) {
         this.a().notify(this.a.c);
      }

   }
}
