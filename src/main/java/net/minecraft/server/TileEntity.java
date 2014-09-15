package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class TileEntity {

   private static final Logger a = LogManager.getLogger();
   private static Map f = Maps.newHashMap();
   private static Map g = Maps.newHashMap();
   protected World b;
   protected Location c;
   protected boolean d;
   private int h;
   protected Block e;


   public TileEntity() {
      this.c = Location.a;
      this.h = -1;
   }

   private static void a(Class var0, String var1) {
      if(f.containsKey(var1)) {
         throw new IllegalArgumentException("Duplicate id: " + var1);
      } else {
         f.put(var1, var0);
         g.put(var0, var1);
      }
   }

   public World z() {
      return this.b;
   }

   public void a(World var1) {
      this.b = var1;
   }

   public boolean t() {
      return this.b != null;
   }

   public void a(NBTTagCompound var1) {
      this.c = new Location(var1.getInt("x"), var1.getInt("y"), var1.getInt("z"));
   }

   public void b(NBTTagCompound var1) {
      String var2 = (String)g.get(this.getClass());
      if(var2 == null) {
         throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
      } else {
         var1.setString("id", var2);
         var1.setInt("x", this.c.n());
         var1.setInt("y", this.c.o());
         var1.setInt("z", this.c.p());
      }
   }

   public static TileEntity c(NBTTagCompound var0) {
      TileEntity var1 = null;

      try {
         Class var2 = (Class)f.get(var0.getString("id"));
         if(var2 != null) {
            var1 = (TileEntity)var2.newInstance();
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      if(var1 != null) {
         var1.a(var0);
      } else {
         a.warn("Skipping BlockEntity with id " + var0.getString("id"));
      }

      return var1;
   }

   public int u() {
      if(this.h == -1) {
         IBlockData var1 = this.b.getData(this.c);
         this.h = var1.c().c(var1);
      }

      return this.h;
   }

   public void o_() {
      if(this.b != null) {
         IBlockData var1 = this.b.getData(this.c);
         this.h = var1.c().c(var1);
         this.b.b(this.c, this);
         if(this.w() != Blocks.AIR) {
            this.b.e(this.c, this.w());
         }
      }

   }

   public Location v() {
      return this.c;
   }

   public Block w() {
      if(this.e == null) {
         this.e = this.b.getData(this.c).c();
      }

      return this.e;
   }

   public Packet x_() {
      return null;
   }

   public boolean x() {
      return this.d;
   }

   public void y() {
      this.d = true;
   }

   public void D() {
      this.d = false;
   }

   public boolean c(int var1, int var2) {
      return false;
   }

   public void E() {
      this.e = null;
      this.h = -1;
   }

   public void a(CrashReportSystemDetails var1) {
      var1.a("Name", (Callable)(new CrashReportTileEntityName(this)));
      if(this.b != null) {
         CrashReportSystemDetails.a(var1, this.c, this.w(), this.u());
         var1.a("Actual block type", (Callable)(new CrashReportTileEntityType(this)));
         var1.a("Actual block data value", (Callable)(new CrashReportTileEntityData(this)));
      }
   }

   public void a(Location var1) {
      this.c = var1;
   }

   // $FF: synthetic method
   static Map F() {
      return g;
   }

   static {
      a(TileEntityFurnace.class, "Furnace");
      a(TileEntityChest.class, "Chest");
      a(TileEntityEnderChest.class, "EnderChest");
      a(TileEntityRecordPlayer.class, "RecordPlayer");
      a(TileEntityDispenser.class, "Trap");
      a(TileEntityDropper.class, "Dropper");
      a(TileEntitySign.class, "Sign");
      a(TileEntityMobSpawner.class, "MobSpawner");
      a(TileEntityNote.class, "Music");
      a(TileEntityPiston.class, "Piston");
      a(TileEntityBrewingStand.class, "Cauldron");
      a(TileEntityEnchantTable.class, "EnchantTable");
      a(TileEntityEnderPortal.class, "Airportal");
      a(TileEntityCommand.class, "Control");
      a(TileEntityBeacon.class, "Beacon");
      a(TileEntitySkull.class, "Skull");
      a(TileEntityLightDetector.class, "DLDetector");
      a(TileEntityHopper.class, "Hopper");
      a(TileEntityComparator.class, "Comparator");
      a(TileEntityFlowerPot.class, "FlowerPot");
      a(TileEntityBanner.class, "Banner");
   }
}
