import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RequestService } from '../_services/request.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  isActive = false;
  paymentSuccess = false;
  paymentId = '';
  @Input() requestId = '';
  @Input() processingCharge: string = '';
  isLoggedIn = false;
  errorMessage = '';
  requestFailed = false;
  @Input() pakadgingAndDeliveryCharge = '';
  @Output() onPaymentDone = new EventEmitter<any>();


  form: any = {
    requestId: null,
    cardNumber: null,
    cardLimit: null,
    processingCharge: null,
    pakadgingAndDeliveryCharge: null
  };

  constructor(private route: ActivatedRoute, private tokenStorageService: TokenStorageService, 
    private requestService: RequestService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    this.form.requestId = this.requestId;
    this.form.processingCharge = this.processingCharge;
    this.form.pakadgingAndDeliveryCharge = this.pakadgingAndDeliveryCharge;
  }

  onSubmit(): void {
    const { requestId, cardNumber, cardLimit, processingCharge } = this.form;

    this.requestService.payment(requestId, cardNumber, cardLimit, processingCharge).subscribe({
      next:response=>{
        console.log(response)
        this.paymentId = response.paymentId;
        this.paymentSuccess = response.paymentSuccess;
        this.onPaymentDone.emit(response.paymentSuccess);
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.requestFailed = true;
      }
    })
  }

}
