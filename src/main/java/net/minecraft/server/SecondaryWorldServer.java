package net.minecraft.server;

public class SecondaryWorldServer extends WorldServer {

   private WorldServer a;


   public SecondaryWorldServer(MinecraftServer var1, IDataManager var2, int var3, WorldServer var4, MethodProfiler var5) {
      super(var1, var2, new bql(var4.P()), var3, var5);
      this.a = var4;
      var4.af().a((WorldBorderListener)(new qm(this)));
   }

   protected void a() {}

   public World b() {
      this.worldMaps = this.a.T();
      this.C = this.a.Z();
      String var1 = VillageSiege.a(this.t);
      VillageSiege var2 = (VillageSiege)this.worldMaps.a(VillageSiege.class, var1);
      if(var2 == null) {
         this.A = new VillageSiege(this);
         this.worldMaps.a(var1, (PersistentBase)this.A);
      } else {
         this.A = var2;
         this.A.a((World)this);
      }

      return this;
   }
}
