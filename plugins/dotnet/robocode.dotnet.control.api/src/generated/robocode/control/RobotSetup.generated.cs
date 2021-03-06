/**
 * Copyright (c) 2001-2016 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 */
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by jni4net. See http://jni4net.sourceforge.net/ 
//     Runtime Version:2.0.50727.8669
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace robocode.control {
    
    
    #region Component Designer generated code 
    [global::net.sf.jni4net.attributes.JavaClassAttribute()]
    public partial class RobotSetup : global::java.lang.Object, global::java.io.Serializable {
        
        internal new static global::java.lang.Class staticClass;
        
        internal static global::net.sf.jni4net.jni.MethodId j4n_getX0;
        
        internal static global::net.sf.jni4net.jni.MethodId j4n_getY1;
        
        internal static global::net.sf.jni4net.jni.MethodId j4n_getHeading2;
        
        internal static global::net.sf.jni4net.jni.MethodId j4n__ctorRobotSetup3;
        
        [global::net.sf.jni4net.attributes.JavaMethodAttribute("(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V")]
        public RobotSetup(global::java.lang.Double par0, global::java.lang.Double par1, global::java.lang.Double par2) : 
                base(((global::net.sf.jni4net.jni.JNIEnv)(null))) {
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.ThreadEnv;
            using(new global::net.sf.jni4net.jni.LocalFrame(@__env, 16)){
            @__env.NewObject(global::robocode.control.RobotSetup.staticClass, global::robocode.control.RobotSetup.j4n__ctorRobotSetup3, this, global::net.sf.jni4net.utils.Convertor.ParStrongCp2J(par0), global::net.sf.jni4net.utils.Convertor.ParStrongCp2J(par1), global::net.sf.jni4net.utils.Convertor.ParStrongCp2J(par2));
            }
        }
        
        protected RobotSetup(global::net.sf.jni4net.jni.JNIEnv @__env) : 
                base(@__env) {
        }
        
        public static global::java.lang.Class _class {
            get {
                return global::robocode.control.RobotSetup.staticClass;
            }
        }
        
        private static void InitJNI(global::net.sf.jni4net.jni.JNIEnv @__env, java.lang.Class @__class) {
            global::robocode.control.RobotSetup.staticClass = @__class;
            global::robocode.control.RobotSetup.j4n_getX0 = @__env.GetMethodID(global::robocode.control.RobotSetup.staticClass, "getX", "()Ljava/lang/Double;");
            global::robocode.control.RobotSetup.j4n_getY1 = @__env.GetMethodID(global::robocode.control.RobotSetup.staticClass, "getY", "()Ljava/lang/Double;");
            global::robocode.control.RobotSetup.j4n_getHeading2 = @__env.GetMethodID(global::robocode.control.RobotSetup.staticClass, "getHeading", "()Ljava/lang/Double;");
            global::robocode.control.RobotSetup.j4n__ctorRobotSetup3 = @__env.GetMethodID(global::robocode.control.RobotSetup.staticClass, "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V");
        }
        
        [global::net.sf.jni4net.attributes.JavaMethodAttribute("()Ljava/lang/Double;")]
        public virtual global::java.lang.Double getX() {
            global::net.sf.jni4net.jni.JNIEnv @__env = this.Env;
            using(new global::net.sf.jni4net.jni.LocalFrame(@__env, 10)){
            return global::net.sf.jni4net.utils.Convertor.StrongJ2Cp<global::java.lang.Double>(@__env, @__env.CallObjectMethodPtr(this, global::robocode.control.RobotSetup.j4n_getX0));
            }
        }
        
        [global::net.sf.jni4net.attributes.JavaMethodAttribute("()Ljava/lang/Double;")]
        public virtual global::java.lang.Double getY() {
            global::net.sf.jni4net.jni.JNIEnv @__env = this.Env;
            using(new global::net.sf.jni4net.jni.LocalFrame(@__env, 10)){
            return global::net.sf.jni4net.utils.Convertor.StrongJ2Cp<global::java.lang.Double>(@__env, @__env.CallObjectMethodPtr(this, global::robocode.control.RobotSetup.j4n_getY1));
            }
        }
        
        [global::net.sf.jni4net.attributes.JavaMethodAttribute("()Ljava/lang/Double;")]
        public virtual global::java.lang.Double getHeading() {
            global::net.sf.jni4net.jni.JNIEnv @__env = this.Env;
            using(new global::net.sf.jni4net.jni.LocalFrame(@__env, 10)){
            return global::net.sf.jni4net.utils.Convertor.StrongJ2Cp<global::java.lang.Double>(@__env, @__env.CallObjectMethodPtr(this, global::robocode.control.RobotSetup.j4n_getHeading2));
            }
        }
        
        new internal sealed class ContructionHelper : global::net.sf.jni4net.utils.IConstructionHelper {
            
            public global::net.sf.jni4net.jni.IJvmProxy CreateProxy(global::net.sf.jni4net.jni.JNIEnv @__env) {
                return new global::robocode.control.RobotSetup(@__env);
            }
        }
    }
    #endregion
}
