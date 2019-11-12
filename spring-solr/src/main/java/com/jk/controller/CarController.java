/**
 * @ClassNameCarController
 * @Description
 * @Author
 * @Date2019/11/11 17:27
 * @Version V1.0
 **/

package com.jk.controller;

import com.jk.model.Car;
import com.jk.service.CarService;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private SolrClient client;
    @RequestMapping("addCar")
    @ResponseBody
    public String addCar(Car car) {
        Car car1 = carService.addCar(car);
        try {
            SolrInputDocument doc = new SolrInputDocument();
            doc.setField("id", car1.getCarId());
            doc.setField("carName", car1.getCarName());
            doc.setField("carDate", car1.getCarDate());
            doc.setField("carPrice",car1.getCarPrice());
            /* 如果spring.data.solr.host 里面配置到 core了, 那么这里就不需要传 collection1 这个参数
             * 下面都是一样的
             */

            client.add("core1", doc);
            //client.commit();
            client.commit("core1");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
    @RequestMapping("deleteCarById")
    @ResponseBody
    public String deleteCarById(String id)  {
        carService.deleteCar(id);
        try {
            client.deleteById("core1",id);
            client.commit("core1");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("queryCarById")
    @ResponseBody
    public SolrDocument getById(String id) throws Exception {
        SolrDocument document = client.getById("core1", id);
        System.out.println(document);
        return document;
    }
    @RequestMapping("queryCar")
    @ResponseBody
    public Map<String, Object> queryCar(int page,int rows,Car car){
        Map<String,Object> map1 = new HashMap<String, Object>();
        try {
            SolrQuery params = new SolrQuery();
            //查询条件, 这里的 q 对应 下面图片标红的地方
            if (car.getCarName()!=null && !"".equals(car.getCarName())){
                params.set("q", car.getCarName());
            }else {
                params.set("q","*:*");
            }
            //过滤条件
            //params.set("fq", "product_price:[100 TO 100000]");
            //排序
           params.addSort("carPrice", SolrQuery.ORDER.asc);
            //分页
            params.setStart((page-1)*rows);
            params.setRows(rows);
            //默认域
            params.set("df", "carName");

            //只查询指定域
            //params.set("fl", "id,product_title,product_price");

            //高亮
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("carName");
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");

            //查询后返回的对象
            QueryResponse queryResponse = client.query("core1",params);
            //查询后返回的对象 获得真正的查询结果
            SolrDocumentList results = queryResponse.getResults();
            //查询的总条数
            long numFound = results.getNumFound();

            System.out.println(numFound);
            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
            List<Car> list1 =new ArrayList<Car>();
            for (SolrDocument result : results) {
                Car car1 = new Car();
                String highFile="";
                Map<String, List<String>> map = highlight.get(result.get("id"));
                List<String> list = map.get("carName");
                if (list==null){
                    highFile = (String)result.get("carName");
                }else {
                    highFile=list.get(0);
                }
                car1.setCarId(Integer.valueOf((String)result.get("id").toString()));
                car1.setCarName(highFile);
                car1.setCarDate(((Date) result.get("carDate")));

                car1.setCarPrice(Double.valueOf(result.get("carPrice").toString()));


                list1.add(car1);
            }
            map1.put("total",numFound);
            map1.put("rows",list1);
            return map1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}