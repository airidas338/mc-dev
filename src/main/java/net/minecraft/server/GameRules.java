package net.minecraft.server;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class GameRules {

   private TreeMap a = new TreeMap();


   public GameRules() {
      this.a("doFireTick", "true", GameRuleInputType.BOOLEAN_VALUE);
      this.a("mobGriefing", "true", GameRuleInputType.BOOLEAN_VALUE);
      this.a("keepInventory", "false", GameRuleInputType.BOOLEAN_VALUE);
      this.a("doMobSpawning", "true", GameRuleInputType.BOOLEAN_VALUE);
      this.a("doMobLoot", "true", GameRuleInputType.BOOLEAN_VALUE);
      this.a("doTileDrops", "true", GameRuleInputType.BOOLEAN_VALUE);
      this.a("commandBlockOutput", "true", GameRuleInputType.BOOLEAN_VALUE);
      this.a("naturalRegeneration", "true", GameRuleInputType.BOOLEAN_VALUE);
      this.a("doDaylightCycle", "true", GameRuleInputType.BOOLEAN_VALUE);
      this.a("logAdminCommands", "true", GameRuleInputType.BOOLEAN_VALUE);
      this.a("showDeathMessages", "true", GameRuleInputType.BOOLEAN_VALUE);
      this.a("randomTickSpeed", "3", GameRuleInputType.NUMERICAL_VALUE);
      this.a("sendCommandFeedback", "true", GameRuleInputType.BOOLEAN_VALUE);
      this.a("reducedDebugInfo", "false", GameRuleInputType.BOOLEAN_VALUE);
   }

   public void a(String var1, String var2, GameRuleInputType var3) {
      this.a.put(var1, new GameRuleValue(var2, var3));
   }

   public void set(String var1, String var2) {
      GameRuleValue var3 = (GameRuleValue)this.a.get(var1);
      if(var3 != null) {
         var3.a(var2);
      } else {
         this.a(var1, var2, GameRuleInputType.ANY_VALUE);
      }

   }

   public String get(String var1) {
      GameRuleValue var2 = (GameRuleValue)this.a.get(var1);
      return var2 != null?var2.a():"";
   }

   public boolean getBoolean(String var1) {
      GameRuleValue var2 = (GameRuleValue)this.a.get(var1);
      return var2 != null?var2.b():false;
   }

   public int getInt(String var1) {
      GameRuleValue var2 = (GameRuleValue)this.a.get(var1);
      return var2 != null?var2.c():0;
   }

   public NBTTagCompound a() {
      NBTTagCompound var1 = new NBTTagCompound();
      Iterator var2 = this.a.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         GameRuleValue var4 = (GameRuleValue)this.a.get(var3);
         var1.setString(var3, var4.a());
      }

      return var1;
   }

   public void a(NBTTagCompound var1) {
      Set var2 = var1.c();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         String var6 = var1.getString(var4);
         this.set(var4, var6);
      }

   }

   public String[] b() {
      return (String[])this.a.keySet().toArray(new String[0]);
   }

   public boolean e(String var1) {
      return this.a.containsKey(var1);
   }

   public boolean a(String var1, GameRuleInputType var2) {
      GameRuleValue var3 = (GameRuleValue)this.a.get(var1);
      return var3 != null && (var3.e() == var2 || var2 == GameRuleInputType.ANY_VALUE);
   }
}
