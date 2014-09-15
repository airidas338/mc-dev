package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StatisticList {

   protected static Map a = Maps.newHashMap();
   public static List stats = Lists.newArrayList();
   public static List c = Lists.newArrayList();
   public static List d = Lists.newArrayList();
   public static List e = Lists.newArrayList();
   public static Statistic f = (new CounterStatistic("stat.leaveGame", new ChatMessage("stat.leaveGame", new Object[0]))).i().h();
   public static Statistic g = (new CounterStatistic("stat.playOneMinute", new ChatMessage("stat.playOneMinute", new Object[0]), Statistic.h)).i().h();
   public static Statistic h = (new CounterStatistic("stat.timeSinceDeath", new ChatMessage("stat.timeSinceDeath", new Object[0]), Statistic.h)).i().h();
   public static Statistic i = (new CounterStatistic("stat.walkOneCm", new ChatMessage("stat.walkOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic j = (new CounterStatistic("stat.crouchOneCm", new ChatMessage("stat.crouchOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic k = (new CounterStatistic("stat.sprintOneCm", new ChatMessage("stat.sprintOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic l = (new CounterStatistic("stat.swimOneCm", new ChatMessage("stat.swimOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic m = (new CounterStatistic("stat.fallOneCm", new ChatMessage("stat.fallOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic n = (new CounterStatistic("stat.climbOneCm", new ChatMessage("stat.climbOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic o = (new CounterStatistic("stat.flyOneCm", new ChatMessage("stat.flyOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic p = (new CounterStatistic("stat.diveOneCm", new ChatMessage("stat.diveOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic q = (new CounterStatistic("stat.minecartOneCm", new ChatMessage("stat.minecartOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic r = (new CounterStatistic("stat.boatOneCm", new ChatMessage("stat.boatOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic s = (new CounterStatistic("stat.pigOneCm", new ChatMessage("stat.pigOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic t = (new CounterStatistic("stat.horseOneCm", new ChatMessage("stat.horseOneCm", new Object[0]), Statistic.i)).i().h();
   public static Statistic u = (new CounterStatistic("stat.jump", new ChatMessage("stat.jump", new Object[0]))).i().h();
   public static Statistic v = (new CounterStatistic("stat.drop", new ChatMessage("stat.drop", new Object[0]))).i().h();
   public static Statistic w = (new CounterStatistic("stat.damageDealt", new ChatMessage("stat.damageDealt", new Object[0]), Statistic.j)).h();
   public static Statistic x = (new CounterStatistic("stat.damageTaken", new ChatMessage("stat.damageTaken", new Object[0]), Statistic.j)).h();
   public static Statistic y = (new CounterStatistic("stat.deaths", new ChatMessage("stat.deaths", new Object[0]))).h();
   public static Statistic z = (new CounterStatistic("stat.mobKills", new ChatMessage("stat.mobKills", new Object[0]))).h();
   public static Statistic A = (new CounterStatistic("stat.animalsBred", new ChatMessage("stat.animalsBred", new Object[0]))).h();
   public static Statistic B = (new CounterStatistic("stat.playerKills", new ChatMessage("stat.playerKills", new Object[0]))).h();
   public static Statistic C = (new CounterStatistic("stat.fishCaught", new ChatMessage("stat.fishCaught", new Object[0]))).h();
   public static Statistic D = (new CounterStatistic("stat.junkFished", new ChatMessage("stat.junkFished", new Object[0]))).h();
   public static Statistic E = (new CounterStatistic("stat.treasureFished", new ChatMessage("stat.treasureFished", new Object[0]))).h();
   public static Statistic F = (new CounterStatistic("stat.talkedToVillager", new ChatMessage("stat.talkedToVillager", new Object[0]))).h();
   public static Statistic G = (new CounterStatistic("stat.tradedWithVillager", new ChatMessage("stat.tradedWithVillager", new Object[0]))).h();
   public static final Statistic[] H = new Statistic[4096];
   public static final Statistic[] I = new Statistic[32000];
   public static final Statistic[] J = new Statistic[32000];
   public static final Statistic[] K = new Statistic[32000];


   public static void a() {
      c();
      d();
      e();
      b();
      AchievementList.a();
      EntityTypes.a();
   }

   private static void b() {
      HashSet var0 = Sets.newHashSet();
      Iterator var1 = aop.a().b().iterator();

      while(var1.hasNext()) {
         aoo var2 = (aoo)var1.next();
         if(var2.b() != null) {
            var0.add(var2.b().b());
         }
      }

      var1 = aok.a().b().values().iterator();

      while(var1.hasNext()) {
         ItemStack var5 = (ItemStack)var1.next();
         var0.add(var5.b());
      }

      var1 = var0.iterator();

      while(var1.hasNext()) {
         Item var6 = (Item)var1.next();
         if(var6 != null) {
            int var3 = Item.b(var6);
            String var4 = a(var6);
            if(var4 != null) {
               I[var3] = (new CraftingStatistic("stat.craftItem.", var4, new ChatMessage("stat.craftItem", new Object[]{(new ItemStack(var6)).C()}), var6)).h();
            }
         }
      }

      a(I);
   }

   private static void c() {
      Iterator var0 = Block.REGISTRY.iterator();

      while(var0.hasNext()) {
         Block var1 = (Block)var0.next();
         Item var2 = Item.a(var1);
         if(var2 != null) {
            int var3 = Block.getId(var1);
            String var4 = a(var2);
            if(var4 != null && var1.I()) {
               H[var3] = (new CraftingStatistic("stat.mineBlock.", var4, new ChatMessage("stat.mineBlock", new Object[]{(new ItemStack(var1)).C()}), var2)).h();
               e.add((CraftingStatistic)H[var3]);
            }
         }
      }

      a(H);
   }

   private static void d() {
      Iterator var0 = Item.e.iterator();

      while(var0.hasNext()) {
         Item var1 = (Item)var0.next();
         if(var1 != null) {
            int var2 = Item.b(var1);
            String var3 = a(var1);
            if(var3 != null) {
               J[var2] = (new CraftingStatistic("stat.useItem.", var3, new ChatMessage("stat.useItem", new Object[]{(new ItemStack(var1)).C()}), var1)).h();
               if(!(var1 instanceof aju)) {
                  d.add((CraftingStatistic)J[var2]);
               }
            }
         }
      }

      a(J);
   }

   private static void e() {
      Iterator var0 = Item.e.iterator();

      while(var0.hasNext()) {
         Item var1 = (Item)var0.next();
         if(var1 != null) {
            int var2 = Item.b(var1);
            String var3 = a(var1);
            if(var3 != null && var1.m()) {
               K[var2] = (new CraftingStatistic("stat.breakItem.", var3, new ChatMessage("stat.breakItem", new Object[]{(new ItemStack(var1)).C()}), var1)).h();
            }
         }
      }

      a(K);
   }

   private static String a(Item var0) {
      RegistryPrepender var1 = (RegistryPrepender)Item.e.c(var0);
      return var1 != null?var1.toString().replace(':', '.'):null;
   }

   private static void a(Statistic[] var0) {
      a(var0, Blocks.STATIONARY_WATER, Blocks.WATER);
      a(var0, Blocks.STATIONARY_LAVA, Blocks.LAVA);
      a(var0, Blocks.JACK_O_LANTERN, Blocks.PUMPKIN);
      a(var0, Blocks.BURNING_FURNACE, Blocks.FURNACE);
      a(var0, Blocks.GLOWING_REDSTONE_ORE, Blocks.REDSTONE_ORE);
      a(var0, Blocks.DIODE_ON, Blocks.DIODE_OFF);
      a(var0, Blocks.REDSTONE_COMPARATOR_ON, Blocks.REDSTONE_COMPARATOR_OFF);
      a(var0, Blocks.REDSTONE_TORCH_ON, Blocks.REDSTONE_TORCH_OFF);
      a(var0, Blocks.REDSTONE_LAMP_ON, Blocks.REDSTONE_LAMP_OFF);
      a(var0, Blocks.DOUBLE_STEP1, Blocks.STEP1);
      a(var0, Blocks.WOOD_DOUBLE_STEP, Blocks.WOOD_STEP);
      a(var0, Blocks.DOUBLE_STEP2, Blocks.STEP2);
      a(var0, Blocks.GRASS, Blocks.DIRT);
      a(var0, Blocks.FARMLAND, Blocks.DIRT);
   }

   private static void a(Statistic[] var0, Block var1, Block var2) {
      int var3 = Block.getId(var1);
      int var4 = Block.getId(var2);
      if(var0[var3] != null && var0[var4] == null) {
         var0[var4] = var0[var3];
      } else {
         stats.remove(var0[var3]);
         e.remove(var0[var3]);
         c.remove(var0[var3]);
         var0[var3] = var0[var4];
      }
   }

   public static Statistic a(MonsterEggInfo var0) {
      String var1 = EntityTypes.b(var0.a);
      return var1 == null?null:(new Statistic("stat.killEntity." + var1, new ChatMessage("stat.entityKill", new Object[]{new ChatMessage("entity." + var1 + ".name", new Object[0])}))).h();
   }

   public static Statistic b(MonsterEggInfo var0) {
      String var1 = EntityTypes.b(var0.a);
      return var1 == null?null:(new Statistic("stat.entityKilledBy." + var1, new ChatMessage("stat.entityKilledBy", new Object[]{new ChatMessage("entity." + var1 + ".name", new Object[0])}))).h();
   }

   public static Statistic a(String var0) {
      return (Statistic)a.get(var0);
   }

}
