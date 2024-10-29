package hello.core.order;

// 상태없이
// 기능명세만한다
public interface OrderService {

    // MemberService의 join과 결이 비슷함 (단, 구현클래스에서 주문을 DB로 영속화하진 않고 자바객체로만 남겨놓음)
    Order createOrder(Long memberID, String itemName, int itemPrice);
}
