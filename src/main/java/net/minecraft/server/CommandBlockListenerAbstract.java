package net.minecraft.server;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

public abstract class CommandBlockListenerAbstract implements ICommandListener {

   private static final SimpleDateFormat a = new SimpleDateFormat("HH:mm:ss");
   private int b;
   private boolean c = true;
   private IChatBaseComponent d = null;
   private String e = "";
   private String f = "@";
   private final af g = new af();


   public int j() {
      return this.b;
   }

   public IChatBaseComponent k() {
      return this.d;
   }

   public void a(NBTTagCompound var1) {
      var1.setString("Command", this.e);
      var1.setInt("SuccessCount", this.b);
      var1.setString("CustomName", this.f);
      var1.setBoolean("TrackOutput", this.c);
      if(this.d != null && this.c) {
         var1.setString("LastOutput", hp.a(this.d));
      }

      this.g.b(var1);
   }

   public void b(NBTTagCompound var1) {
      this.e = var1.getString("Command");
      this.b = var1.getInt("SuccessCount");
      if(var1.hasKeyOfType("CustomName", 8)) {
         this.f = var1.getString("CustomName");
      }

      if(var1.hasKeyOfType("TrackOutput", 1)) {
         this.c = var1.getBoolean("TrackOutput");
      }

      if(var1.hasKeyOfType("LastOutput", 8) && this.c) {
         this.d = hp.a(var1.getString("LastOutput"));
      }

      this.g.a(var1);
   }

   public boolean a(int var1, String var2) {
      return var1 <= 2;
   }

   public void a(String var1) {
      this.e = var1;
      this.b = 0;
   }

   public String l() {
      return this.e;
   }

   public void a(World var1) {
      if(var1.isStatic) {
         this.b = 0;
      }

      MinecraftServer var2 = MinecraftServer.M();
      if(var2 != null && var2.N() && var2.aj()) {
         ICommandHandler var3 = var2.O();

         try {
            this.d = null;
            this.b = var3.a(this, this.e);
         } catch (Throwable var7) {
            CrashReport var5 = CrashReport.a(var7, "Executing command block");
            CrashReportSystemDetails var6 = var5.a("Command to be executed");
            var6.a("Command", (Callable)(new aqg(this)));
            var6.a("Name", (Callable)(new aqh(this)));
            throw new ReportedException(var5);
         }
      } else {
         this.b = 0;
      }

   }

   public String getName() {
      return this.f;
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return new ChatComponentText(this.getName());
   }

   public void b(String var1) {
      this.f = var1;
   }

   public void sendMessage(IChatBaseComponent var1) {
      if(this.c && this.getWorld() != null && !this.getWorld().isStatic) {
         this.d = (new ChatComponentText("[" + a.format(new Date()) + "] ")).a(var1);
         this.h();
      }

   }

   public boolean t_() {
      MinecraftServer var1 = MinecraftServer.M();
      return var1 == null || !var1.N() || var1.c[0].Q().b("commandBlockOutput");
   }

   public void a(ag var1, int var2) {
      this.g.a(this, var1, var2);
   }

   public abstract void h();

   public void b(IChatBaseComponent var1) {
      this.d = var1;
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public boolean m() {
      return this.c;
   }

   public boolean a(EntityHuman var1) {
      if(!var1.by.canInstantlyBuild) {
         return false;
      } else {
         if(var1.getWorld().isStatic) {
            var1.a(this);
         }

         return true;
      }
   }

   public af n() {
      return this.g;
   }

}
