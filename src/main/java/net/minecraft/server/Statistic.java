package net.minecraft.server;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Statistic {

   public final String name;
   private final IChatBaseComponent a;
   public boolean f;
   private final tv b;
   private final IScoreboardCriteria c;
   private Class d;
   private static NumberFormat k = NumberFormat.getIntegerInstance(Locale.US);
   public static tv g = new tr();
   private static DecimalFormat l = new DecimalFormat("########0.00");
   public static tv h = new ts();
   public static tv i = new tt();
   public static tv j = new tu();


   public Statistic(String var1, IChatBaseComponent var2, tv var3) {
      this.name = var1;
      this.a = var2;
      this.b = var3;
      this.c = new bsm(this);
      IScoreboardCriteria.criteria.put(this.c.getName(), this.c);
   }

   public Statistic(String var1, IChatBaseComponent var2) {
      this(var1, var2, g);
   }

   public Statistic i() {
      this.f = true;
      return this;
   }

   public Statistic h() {
      if(StatisticList.a.containsKey(this.name)) {
         throw new RuntimeException("Duplicate stat id: \"" + ((Statistic)StatisticList.a.get(this.name)).a + "\" and \"" + this.a + "\" at id " + this.name);
      } else {
         StatisticList.stats.add(this);
         StatisticList.a.put(this.name, this);
         return this;
      }
   }

   public boolean d() {
      return false;
   }

   public IChatBaseComponent e() {
      IChatBaseComponent var1 = this.a.f();
      var1.getChatModifier().setColor(EnumChatFormat.GRAY);
      var1.getChatModifier().a(new ChatHoverable(EnumHoverAction.SHOW_ACHIEVEMENT, new ChatComponentText(this.name)));
      return var1;
   }

   public IChatBaseComponent j() {
      IChatBaseComponent var1 = this.e();
      IChatBaseComponent var2 = (new ChatComponentText("[")).a(var1).a("]");
      var2.setChatModifier(var1.getChatModifier());
      return var2;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         Statistic var2 = (Statistic)var1;
         return this.name.equals(var2.name);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   public String toString() {
      return "Stat{id=" + this.name + ", nameId=" + this.a + ", awardLocallyOnly=" + this.f + ", formatter=" + this.b + ", objectiveCriteria=" + this.c + '}';
   }

   public IScoreboardCriteria k() {
      return this.c;
   }

   public Class l() {
      return this.d;
   }

   public Statistic b(Class var1) {
      this.d = var1;
      return this;
   }

}
