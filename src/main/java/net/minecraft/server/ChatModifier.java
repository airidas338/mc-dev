package net.minecraft.server;

public class ChatModifier {

   private ChatModifier a;
   private EnumChatFormat b;
   private Boolean c;
   private Boolean d;
   private Boolean e;
   private Boolean f;
   private Boolean g;
   private hm h;
   private ChatHoverable i;
   private String j;
   private static final ChatModifier k = new hw();


   public EnumChatFormat a() {
      return this.b == null?this.o().a():this.b;
   }

   public boolean b() {
      return this.c == null?this.o().b():this.c.booleanValue();
   }

   public boolean c() {
      return this.d == null?this.o().c():this.d.booleanValue();
   }

   public boolean d() {
      return this.f == null?this.o().d():this.f.booleanValue();
   }

   public boolean e() {
      return this.e == null?this.o().e():this.e.booleanValue();
   }

   public boolean f() {
      return this.g == null?this.o().f():this.g.booleanValue();
   }

   public boolean g() {
      return this.c == null && this.d == null && this.f == null && this.e == null && this.g == null && this.b == null && this.h == null && this.i == null;
   }

   public hm h() {
      return this.h == null?this.o().h():this.h;
   }

   public ChatHoverable i() {
      return this.i == null?this.o().i():this.i;
   }

   public String j() {
      return this.j == null?this.o().j():this.j;
   }

   public ChatModifier setColor(EnumChatFormat var1) {
      this.b = var1;
      return this;
   }

   public ChatModifier a(Boolean var1) {
      this.c = var1;
      return this;
   }

   public ChatModifier b(Boolean var1) {
      this.d = var1;
      return this;
   }

   public ChatModifier c(Boolean var1) {
      this.f = var1;
      return this;
   }

   public ChatModifier d(Boolean var1) {
      this.e = var1;
      return this;
   }

   public ChatModifier e(Boolean var1) {
      this.g = var1;
      return this;
   }

   public ChatModifier a(hm var1) {
      this.h = var1;
      return this;
   }

   public ChatModifier a(ChatHoverable var1) {
      this.i = var1;
      return this;
   }

   public ChatModifier a(String var1) {
      this.j = var1;
      return this;
   }

   public ChatModifier a(ChatModifier var1) {
      this.a = var1;
      return this;
   }

   private ChatModifier o() {
      return this.a == null?k:this.a;
   }

   public String toString() {
      return "Style{hasParent=" + (this.a != null) + ", color=" + this.b + ", bold=" + this.c + ", italic=" + this.d + ", underlined=" + this.e + ", obfuscated=" + this.g + ", clickEvent=" + this.h() + ", hoverEvent=" + this.i() + ", insertion=" + this.j() + '}';
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof ChatModifier)) {
         return false;
      } else {
         ChatModifier var2 = (ChatModifier)var1;
         boolean var10000;
         if(this.b() == var2.b() && this.a() == var2.a() && this.c() == var2.c() && this.f() == var2.f() && this.d() == var2.d() && this.e() == var2.e()) {
            label65: {
               if(this.h() != null) {
                  if(!this.h().equals(var2.h())) {
                     break label65;
                  }
               } else if(var2.h() != null) {
                  break label65;
               }

               if(this.i() != null) {
                  if(!this.i().equals(var2.i())) {
                     break label65;
                  }
               } else if(var2.i() != null) {
                  break label65;
               }

               if(this.j() != null) {
                  if(!this.j().equals(var2.j())) {
                     break label65;
                  }
               } else if(var2.j() != null) {
                  break label65;
               }

               var10000 = true;
               return var10000;
            }
         }

         var10000 = false;
         return var10000;
      }
   }

   public int hashCode() {
      int var1 = this.b.hashCode();
      var1 = 31 * var1 + this.c.hashCode();
      var1 = 31 * var1 + this.d.hashCode();
      var1 = 31 * var1 + this.e.hashCode();
      var1 = 31 * var1 + this.f.hashCode();
      var1 = 31 * var1 + this.g.hashCode();
      var1 = 31 * var1 + this.h.hashCode();
      var1 = 31 * var1 + this.i.hashCode();
      var1 = 31 * var1 + this.j.hashCode();
      return var1;
   }

   public ChatModifier m() {
      ChatModifier var1 = new ChatModifier();
      var1.c = this.c;
      var1.d = this.d;
      var1.f = this.f;
      var1.e = this.e;
      var1.g = this.g;
      var1.b = this.b;
      var1.h = this.h;
      var1.i = this.i;
      var1.a = this.a;
      var1.j = this.j;
      return var1;
   }

   public ChatModifier n() {
      ChatModifier var1 = new ChatModifier();
      var1.a(Boolean.valueOf(this.b()));
      var1.b(Boolean.valueOf(this.c()));
      var1.c(Boolean.valueOf(this.d()));
      var1.d(Boolean.valueOf(this.e()));
      var1.e(Boolean.valueOf(this.f()));
      var1.setColor(this.a());
      var1.a(this.h());
      var1.a(this.i());
      var1.a(this.j());
      return var1;
   }

   // $FF: synthetic method
   static Boolean a(ChatModifier var0, Boolean var1) {
      return var0.c = var1;
   }

   // $FF: synthetic method
   static Boolean b(ChatModifier var0, Boolean var1) {
      return var0.d = var1;
   }

   // $FF: synthetic method
   static Boolean c(ChatModifier var0, Boolean var1) {
      return var0.e = var1;
   }

   // $FF: synthetic method
   static Boolean d(ChatModifier var0, Boolean var1) {
      return var0.f = var1;
   }

   // $FF: synthetic method
   static Boolean e(ChatModifier var0, Boolean var1) {
      return var0.g = var1;
   }

   // $FF: synthetic method
   static EnumChatFormat a(ChatModifier var0, EnumChatFormat var1) {
      return var0.b = var1;
   }

   // $FF: synthetic method
   static String a(ChatModifier var0, String var1) {
      return var0.j = var1;
   }

   // $FF: synthetic method
   static hm a(ChatModifier var0, hm var1) {
      return var0.h = var1;
   }

   // $FF: synthetic method
   static ChatHoverable a(ChatModifier var0, ChatHoverable var1) {
      return var0.i = var1;
   }

   // $FF: synthetic method
   static Boolean b(ChatModifier var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static Boolean c(ChatModifier var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static Boolean d(ChatModifier var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static Boolean e(ChatModifier var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static Boolean f(ChatModifier var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static EnumChatFormat g(ChatModifier var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static String h(ChatModifier var0) {
      return var0.j;
   }

   // $FF: synthetic method
   static hm i(ChatModifier var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static ChatHoverable j(ChatModifier var0) {
      return var0.i;
   }

}
