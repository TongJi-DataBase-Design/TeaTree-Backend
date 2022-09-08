package cn.edu.tongji.teatreebackend.Dtos;

import java.util.ArrayList;
import java.util.List;

public class SearchConditionsDto {
    public int pageNo;
    public int pageSize;
    public String keyword;
    public int articleType;
    public List<String> checkedDistributionGroup;
}
