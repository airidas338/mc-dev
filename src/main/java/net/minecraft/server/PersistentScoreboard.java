package net.minecraft.server;
import java.util.Collection;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersistentScoreboard extends PersistentBase {

   private static final Logger b = LogManager.getLogger();
   private Scoreboard c;
   private NBTTagCompound d;


   public PersistentScoreboard() {
      this("scoreboard");
   }

   public PersistentScoreboard(String var1) {
      super(var1);
   }

   public void a(Scoreboard var1) {
      this.c = var1;
      if(this.d != null) {
         this.a(this.d);
      }

   }

   public void a(NBTTagCompound var1) {
      if(this.c == null) {
         this.d = var1;
      } else {
         this.b(var1.getList("Objectives", 10));
         this.c(var1.getList("PlayerScores", 10));
         if(var1.b("DisplaySlots", 10)) {
            this.c(var1.getCompound("DisplaySlots"));
         }

         if(var1.b("Teams", 9)) {
            this.a(var1.getList("Teams", 10));
         }

      }
   }

   protected void a(NBTTagList var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         NBTTagCompound var3 = var1.b(var2);
         ScoreboardTeam var4 = this.c.e(var3.getString("Name"));
         var4.a(var3.getString("DisplayName"));
         if(var3.b("TeamColor", 8)) {
            var4.a(EnumChatFormat.b(var3.getString("TeamColor")));
         }

         var4.b(var3.getString("Prefix"));
         var4.c(var3.getString("Suffix"));
         if(var3.b("AllowFriendlyFire", 99)) {
            var4.a(var3.n("AllowFriendlyFire"));
         }

         if(var3.b("SeeFriendlyInvisibles", 99)) {
            var4.b(var3.n("SeeFriendlyInvisibles"));
         }

         bsg var5;
         if(var3.b("NameTagVisibility", 8)) {
            var5 = bsg.a(var3.getString("NameTagVisibility"));
            if(var5 != null) {
               var4.a(var5);
            }
         }

         if(var3.b("DeathMessageVisibility", 8)) {
            var5 = bsg.a(var3.getString("DeathMessageVisibility"));
            if(var5 != null) {
               var4.b(var5);
            }
         }

         this.a(var4, var3.getList("Players", 8));
      }

   }

   protected void a(ScoreboardTeam var1, NBTTagList var2) {
      for(int var3 = 0; var3 < var2.c(); ++var3) {
         this.c.a(var2.f(var3), var1.b());
      }

   }

   protected void c(NBTTagCompound var1) {
      for(int var2 = 0; var2 < 19; ++var2) {
         if(var1.b("slot_" + var2, 8)) {
            String var3 = var1.getString("slot_" + var2);
            bry var4 = this.c.b(var3);
            this.c.a(var2, var4);
         }
      }

   }

   protected void b(NBTTagList var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         NBTTagCompound var3 = var1.b(var2);
         bsk var4 = (bsk)bsk.a.get(var3.getString("CriteriaName"));
         if(var4 != null) {
            bry var5 = this.c.a(var3.getString("Name"), var4);
            var5.a(var3.getString("DisplayName"));
            var5.a(bsl.a(var3.getString("RenderType")));
         }
      }

   }

   protected void c(NBTTagList var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         NBTTagCompound var3 = var1.b(var2);
         bry var4 = this.c.b(var3.getString("Objective"));
         bsa var5 = this.c.c(var3.getString("Name"), var4);
         var5.c(var3.getInt("Score"));
         if(var3.c("Locked")) {
            var5.a(var3.n("Locked"));
         }
      }

   }

   public void b(NBTTagCompound var1) {
      if(this.c == null) {
         b.warn("Tried to save scoreboard without having a scoreboard...");
      } else {
         var1.set("Objectives", (NBTBase)this.b());
         var1.set("PlayerScores", (NBTBase)this.e());
         var1.set("Teams", (NBTBase)this.a());
         this.d(var1);
      }
   }

   protected NBTTagList a() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.c.g();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         ScoreboardTeam var4 = (ScoreboardTeam)var3.next();
         NBTTagCompound var5 = new NBTTagCompound();
         var5.setString("Name", var4.b());
         var5.setString("DisplayName", var4.c());
         if(var4.l().b() >= 0) {
            var5.setString("TeamColor", var4.l().e());
         }

         var5.setString("Prefix", var4.e());
         var5.setString("Suffix", var4.f());
         var5.setBoolean("AllowFriendlyFire", var4.g());
         var5.setBoolean("SeeFriendlyInvisibles", var4.h());
         var5.setString("NameTagVisibility", var4.i().e);
         var5.setString("DeathMessageVisibility", var4.j().e);
         NBTTagList var6 = new NBTTagList();
         Iterator var7 = var4.d().iterator();

         while(var7.hasNext()) {
            String var8 = (String)var7.next();
            var6.a((NBTBase)(new NBTTagString(var8)));
         }

         var5.set("Players", (NBTBase)var6);
         var1.a((NBTBase)var5);
      }

      return var1;
   }

   protected void d(NBTTagCompound var1) {
      NBTTagCompound var2 = new NBTTagCompound();
      boolean var3 = false;

      for(int var4 = 0; var4 < 19; ++var4) {
         bry var5 = this.c.a(var4);
         if(var5 != null) {
            var2.setString("slot_" + var4, var5.b());
            var3 = true;
         }
      }

      if(var3) {
         var1.set("DisplaySlots", (NBTBase)var2);
      }

   }

   protected NBTTagList b() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.c.c();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         bry var4 = (bry)var3.next();
         if(var4.c() != null) {
            NBTTagCompound var5 = new NBTTagCompound();
            var5.setString("Name", var4.b());
            var5.setString("CriteriaName", var4.c().a());
            var5.setString("DisplayName", var4.d());
            var5.setString("RenderType", var4.e().a());
            var1.a((NBTBase)var5);
         }
      }

      return var1;
   }

   protected NBTTagList e() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.c.e();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         bsa var4 = (bsa)var3.next();
         if(var4.d() != null) {
            NBTTagCompound var5 = new NBTTagCompound();
            var5.setString("Name", var4.e());
            var5.setString("Objective", var4.d().b());
            var5.setInt("Score", var4.c());
            var5.setBoolean("Locked", var4.g());
            var1.a((NBTBase)var5);
         }
      }

      return var1;
   }

}
