package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {//��ַ��111
    private Integer aid;//����
    private Users users;//�û����
    private District sheng;//ʡid
    private District shi;//��id
    private District xian;//��id
    private String street;//��ϸ�ֵ���ַ
}
