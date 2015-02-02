/**
 * <b>项目名：</b>mypic_front<br/>  
 * <b>包名：</b>com.sxj.core.mputil<br/>  
 * <b>文件名：</b>MybatisMapperUtil.java<br/> 
 * <b>日期：</b>2013-6-24 上午09:33:41<br/>  
 * <b>Copyright (c)</b> <br/>    
 */
package com.youchat.test.util;

import java.io.FileOutputStream;
import java.lang.reflect.Field;

import javax.persistence.Id;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.youchat.entity.user.Manager;




/** 
 * <b>类描述：</b><br/>  
 * <b>@author </b>lusar<br/>  
 * <b>修改时间：</b>2013-6-24 上午09:33:41<br/> 
 * <b>修改备注：</b><br/> 
 *
 */
public class MybatisMapperUtil_Oracle {
    public static void main(String[] args) {
        buildMapperXml("seq_order",Manager.class,"com.youchat.dao.user","E:\\program\\紫藤\\develop\\kk\\config\\mapper","");
        System.out.println("create over");
    }
    
    
    
    /**
     * 功能描述: 构造实体对象Mybatis Mapper配置文件<br/> 
     * @param className 
     * @author lusar
     * 日期:2013-6-24 下午06:37:43
     */
    public static void buildMapperXml(String seq,Class className,String daoPackage,String outputPath,String tablePrefix){
        bulidGeneralMapper(seq,className,daoPackage,outputPath,tablePrefix);
    }
    
    /**
     * 功能描述: 创建简单mapper无复合型的，如含有其他对象或者集合类型的<br/> 
     * @param className 
     * @author lusar
     * 日期:2013-6-24 下午06:37:10
     */
    private static void bulidGeneralMapper(String seq,Class className,String daoPackage,String outputPath,String tablePrefix){
        buildXml(seq,className,daoPackage,outputPath,tablePrefix);
    }
    
    
    private static void buildXml(String seq,Class className,String daoPackage,String outputPath,String tablePrefix){
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");// 设置XML文件的编码格式
        format.setLineSeparator("\n");
        format.setTrimText(false);
        format.setIndent("  ");
        Document doc = DocumentHelper.createDocument();
        doc.addDocType("mapper", "-//ibatis.apache.org//DTD Mapper 3.0//EN", "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd");
        Element root = doc.addElement("mapper");
        root.addAttribute("namespace", daoPackage+".I"+className.getSimpleName()+"Dao");
        //创建resultMap
        Element resultMapElement = buildResultMap(className);
        root.add(resultMapElement);
        //创建insert
        root.add(buildInsert(seq,className,tablePrefix));
        //创建update
        root.add(buildUpdate(className,tablePrefix));
        //创建DeleteById
        root.add(buildDeleteById(className,tablePrefix));
        //创建delete
        root.add(buildDelete(className,tablePrefix));
        //创建SelectById
        root.add(buildSelectById(className,tablePrefix));
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(outputPath+"/"+buildFileName(className)),format);
            writer.setEscapeText(false);
            writer.write(doc);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    /**
     * 功能描述: 构造SelectById<br/> 
     * @param className
     * @return 
     * @author lusar
     * 日期:2013-6-24 下午06:20:13
     */
    private static Element buildSelectById(Class className,String tablePrefix){
        Element el = DocumentHelper.createElement("select");
        el.addAttribute("id", "selectById");
        el.addAttribute("parameterType", "int");
        el.addAttribute("useCache","true");
        el.addAttribute("resultMap", buildResultMapId(className));
        StringBuffer sbf = new StringBuffer();
        sbf.append("\n\t\t").append("select * from ").append(buildTableName(className, tablePrefix)).append(" where id=#{value}").append("\n\t");
        el.addText(sbf.toString());
        return el;
    }
    
    /**
     * 功能描述: 创建delete<br/> 
     * @param className
     * @return 
     * @author lusar
     * 日期:2013-6-24 下午06:02:01
     */
    private static Element buildDelete(Class className,String tablePrefix){
        Element el = DocumentHelper.createElement("delete");
        el.addAttribute("id", "deleteById");
        el.addAttribute("parameterType", "int");
        el.addAttribute("flushCache", "true");
        StringBuffer sbf = new StringBuffer();
        sbf.append("\n\t\t").append("delete from ").append(buildTableName(className, tablePrefix)).append(" where id=#{id}").append("\n\t");
        el.addText(sbf.toString());
        return el;
    }
    /**
     * 功能描述: 创建DeleteById<br/> 
     * @param className
     * @return 
     * @author lusar
     * 日期:2013-6-24 下午05:58:59
     */
    private static Element buildDeleteById(Class className,String tablePrefix){
        Element el = DocumentHelper.createElement("delete");
        el.addAttribute("id", "delete");
        el.addAttribute("parameterType", className.getName());
        el.addAttribute("flushCache", "true");
        StringBuffer sbf = new StringBuffer();
        sbf.append("\n\t\t").append("delete from ").append(buildTableName(className, tablePrefix)).append(" where id=#{id}").append("\n\t");
        el.addText(sbf.toString());
        return el;
    }
    
    /**
     * 功能描述: 创建更新<br/> 
     * @param className
     * @return 
     * @author lusar
     * 日期:2013-6-24 下午05:53:47
     */
    private static Element buildUpdate(Class className,String tablePrefix){
        Element updateEl = DocumentHelper.createElement("update");
        updateEl.addAttribute("id", "update");
        updateEl.addAttribute("parameterType", className.getName());
        updateEl.addAttribute("flushCache", "true");
        StringBuffer sbf = new StringBuffer();
        sbf.append("\n\t\t").append("update ").append(buildTableName(className, tablePrefix)).append(" set").append("\n\t\t");
        Field[] field = className.getDeclaredFields();
        String propertyName = "";
        String idPropertyName = "";
        for(int i=0;i<field.length;i++){
            propertyName = field[i].getName();
            if(field[i].getAnnotation(Id.class)!=null){idPropertyName=propertyName;}
            if(field[i].getModifiers()==2&&!propertyName.equals("id")&&!propertyName.equals(idPropertyName)&&!propertyName.equals("")){
                sbf.append(changeProperty2Column(propertyName)).append("=").append("#{").append(propertyName);
                if(field[i].toString().indexOf("int")>0||field[i].toString().indexOf("java.lang.Integer")>0){
                    sbf.append(",jdbcType=NUMERIC");
                }else if(field[i].toString().indexOf("java.util.Date")>0){
                    sbf.append(",jdbcType=TIMESTAMP");
                }else if(field[i].toString().indexOf("java.lang.String")>0){
                    sbf.append(",jdbcType=VARCHAR");
                }
                sbf.append("}");
                if(i<field.length-1){
                    sbf.append(",");
                }
                sbf.append("\n\t\t");
            }
        }
        sbf.append("where id=#{id,jdbcType=NUMERIC}").append("\n\t");
        updateEl.addText(sbf.toString());
        return updateEl;
    }
    
    
    /**
     * 功能描述: 创建insert<br/> 
     * @param className
     * @return 
     * @author lusar
     * 日期:2013-6-24 下午03:39:20;
     */
    private static Element buildInsert(String seq,Class className,String tablePrefix){
        Element insertEl = DocumentHelper.createElement("insert");
        insertEl.addAttribute("id", "insert");
        insertEl.addAttribute("parameterType", className.getName());
        insertEl.addAttribute("keyProperty", "id");
        insertEl.addAttribute("useGeneratedKeys", "true");
        insertEl.addAttribute("flushCache", "true");
        Element selectKeyEl = insertEl.addElement("selectKey");
        selectKeyEl.addAttribute("keyProperty", "id");
        selectKeyEl.addAttribute("order", "BEFORE");
        selectKeyEl.addAttribute("resultType", "int");
        StringBuffer keyBuf = new StringBuffer();
        keyBuf.append("\n\t\t\t").append("<![CDATA[SELECT ").append(seq).append(".NEXTVAL AS id FROM DUAL]]>").append("\n\t\t");
        selectKeyEl.addText(keyBuf.toString());
        
        
        StringBuffer sbf = new StringBuffer();
        sbf.append("\n\t\t").append("insert into ").append(buildTableName(className, tablePrefix)).append("\n\t\t").append("(");
        Field[] field = className.getDeclaredFields();
        String propertyName = "";
        for(int i=0;i<field.length;i++){
            propertyName = field[i].getName();
            if(field[i].getModifiers()==2&&!propertyName.equals("")){
                sbf.append(changeProperty2Column(propertyName));
                if(i<field.length-1){
                    sbf.append(",");
                }
            }
        }
        sbf.append(")").append("\n\t\t");
        sbf.append("values").append("\n\t\t").append("(");
        sbf.append("\n\t\t");
        for(int i=0;i<field.length;i++){
            propertyName = field[i].getName();
            if(field[i].getModifiers()==2&&!propertyName.equals("")){
                sbf.append("#{").append(propertyName);
                if(field[i].toString().indexOf("int")>0||field[i].toString().indexOf("java.lang.Integer")>0){
                    sbf.append(",jdbcType=NUMERIC");
                }else if(field[i].toString().indexOf("java.util.Date")>0){
                    sbf.append(",jdbcType=TIMESTAMP");
                }else if(field[i].toString().indexOf("java.lang.String")>0){
                    sbf.append(",jdbcType=VARCHAR");
                }
                sbf.append("}");
                if(i<field.length-1){
                    sbf.append(",");
                }
                sbf.append("\n\t\t");
            }
        }
        sbf.append(")").append("\n\t");
        insertEl.addText(sbf.toString());
        return insertEl;
    }
    
    /**
     * 功能描述: 创建resultMap<br/> 
     * @param className
     * @return 
     * @author lusar
     * 日期:2013-6-24 下午03:19:47
     */
    private static Element buildResultMap(Class className){
//      Element resultMapEl = root.addElement("resultMap");
        Element resultMapEl = DocumentHelper.createElement("resultMap");
        resultMapEl.addAttribute("type", className.getName());
        resultMapEl.addAttribute("id",buildResultMapId(className));
        Element idEl = resultMapEl.addElement("id");
        idEl.addAttribute("property", "id");
        idEl.addAttribute("column", "id");
        Field[] field = className.getDeclaredFields();
        String propertyName = "";
        for(Field f:field){
            propertyName = f.getName();
            if(f.getModifiers()==2&&!propertyName.equals("id")&&!propertyName.equals("")){
                Element proEl = resultMapEl.addElement("result");
                proEl.addAttribute("property", propertyName);
                proEl.addAttribute("column", changeProperty2Column(propertyName));
            }
        }
        return resultMapEl;
    }
    
    /**
     * 功能描述: 属性转换成数据库列<br/>
     * 首字母大写直接转小写，其他中间大写字母转小写，且加前缀"_" 
     * @param pro
     * @return 
     * @author lusar
     * 日期:2013-6-24 下午03:12:08
     */
    private static String changeProperty2Column(String pro){
        StringBuffer sbf = new StringBuffer("");
//      StringBuffer sbf = new StringBuffer("");
        char[] pc = pro.toCharArray();
        for(int i=0;i<pc.length;i++){
            //大写转小写，加“_”前缀
            if(i==0){
                sbf.append(Character.toLowerCase(pc[i]));
            }else {
                if(CharUtils.isAsciiAlphaUpper(pc[i])){
                    sbf.append("_").append(Character.toLowerCase(pc[i]));
                }else {
                    sbf.append(pc[i]);
                }
            }
        }
        return sbf.toString().toUpperCase();
    }
    
    /**
     * 功能描述: 根据类名称构造表名【前缀】+类名称各单词加下划线拼装<br/> 
     * 如：UserAccount  ：有前缀t 则[t_user_account],无前缀则 [user_account]
     * @param className
     * @return 
     * @author lusar
     * 日期:2013-6-24 下午06:08:46
     */
    private static String buildTableName(Class className,String prefix){
        String name = className.getSimpleName();
        char[] cn = name.toCharArray();
        StringBuffer sbf = new StringBuffer();
        if(StringUtils.isNotBlank(prefix)){
            sbf.append(prefix).append("_");
        }
        for(int i=0;i<cn.length;i++){
            if(i==0){
                sbf.append(Character.toLowerCase(cn[i]));
            }else {
                if(CharUtils.isAsciiAlphaUpper(cn[i])){
                    sbf.append("_").append(Character.toLowerCase(cn[i]));
                }else {
                    sbf.append(cn[i]);
                }
            }
        }
        return sbf.toString().toUpperCase();
    }
    
    /**
     * 功能描述: 构造resultMap中ID<br/> 
     * @param className
     * @return 
     * @author lusar
     * 日期:2013-6-24 下午06:16:45
     */
    private static String buildResultMapId(Class className){
        return StringUtils.uncapitalize(className.getSimpleName())+"Map";
    }
    
    /**
     * 功能描述: 构造mapper文件名称<br/> 
     * @param className
     * @return 
     * @author lusar
     * 日期:2013-6-24 下午06:28:53
     */
    private static String buildFileName(Class className){
        return className.getSimpleName()+"Mapper.xml";
    }
}
