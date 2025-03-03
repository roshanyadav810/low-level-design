package example.librarymanagementsystem.service;

import example.librarymanagementsystem.entity.Fine;

public interface IFine {
    Fine createFine(String orderId , Fine fine);
    Fine getFine(String orderId);

}
