package hello.core.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long memberId;

    // Item도 별도class로 추출할 수 있을까?
    private String itemName;
    private int itemPrice;

    private int discountPrice;

    public int calculatePrice() {
        return itemPrice - discountPrice;
    }


}
