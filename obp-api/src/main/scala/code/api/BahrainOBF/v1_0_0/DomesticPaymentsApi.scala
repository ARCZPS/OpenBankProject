package code.api.BahrainOBF.v1_0_0

import code.api.APIFailureNewStyle
import code.api.berlin.group.v1_3.JvalueCaseClass
import net.liftweb.json
import net.liftweb.json._
import code.api.util.APIUtil.{defaultBankId, _}
import code.api.util.NewStyle
import code.api.util.ErrorMessages._
import code.api.util.ApiTag._
import code.api.util.NewStyle.HttpCode
import code.bankconnectors.Connector
import code.model._
import code.util.Helper
import code.views.Views
import net.liftweb.common.Full
import net.liftweb.http.rest.RestHelper
import com.github.dwickern.macros.NameOf.nameOf
import scala.collection.immutable.Nil
import scala.collection.mutable.ArrayBuffer
import com.openbankproject.commons.ExecutionContext.Implicits.global
import scala.concurrent.Future
import code.api.BahrainOBF.v1_0_0.ApiCollector
import code.api.util.ApiTag

object APIMethods_DomesticPaymentsApi extends RestHelper {
    val apiVersion =  ApiCollector.apiVersion
    val resourceDocs = ArrayBuffer[ResourceDoc]()
    val apiRelations = ArrayBuffer[ApiRelation]()
    protected implicit def JvalueToSuper(what: JValue): JvalueCaseClass = JvalueCaseClass(what)

    val endpoints = 
      domesticPaymentsDomesticPaymentIdGet ::
      domesticPaymentsDomesticPaymentIdPaymentDetailsGet ::
      domesticPaymentsPost ::
      Nil

            
     resourceDocs += ResourceDoc(
       domesticPaymentsDomesticPaymentIdGet, 
       apiVersion, 
       nameOf(domesticPaymentsDomesticPaymentIdGet),
       "GET", 
       "/domestic-payments/DOMESTIC_PAYMENT_ID", 
       "Get Domestic Payments by DomesticPaymentId",
       s"""${mockedDataText(true)}
            
            """,
       json.parse(""""""),
       json.parse("""{
  "Meta" : {
    "FirstAvailableDateTime" : { },
    "TotalPages" : 0
  },
  "Links" : {
    "Last" : "http://example.com/aeiou",
    "Prev" : "http://example.com/aeiou",
    "Next" : "http://example.com/aeiou",
    "First" : "http://example.com/aeiou",
    "Self" : "http://example.com/aeiou"
  },
  "Data" : {
    "DomesticPaymentId" : "DomesticPaymentId",
    "Status" : "AcceptedCreditSettlementCompleted",
    "StatusUpdateDateTime" : "2000-01-23T04:56:07.000+00:00",
    "Debtor" : {
      "Name" : "Name"
    },
    "CreationDateTime" : "2000-01-23T04:56:07.000+00:00",
    "ExpectedExecutionDateTime" : "2000-01-23T04:56:07.000+00:00",
    "Refund" : {
      "Account" : {
        "Identification" : { },
        "SchemeName" : { },
        "Name" : "Name"
      }
    },
    "Charges" : [ {
      "Type" : { },
      "Amount" : {
        "Amount" : { },
        "Currency" : { }
      },
      "ChargeBearer" : { }
    }, {
      "Type" : { },
      "Amount" : {
        "Amount" : { },
        "Currency" : { }
      },
      "ChargeBearer" : { }
    } ],
    "ConsentId" : "ConsentId",
    "Initiation" : {
      "SupplementaryData" : { },
      "LocalInstrument" : { },
      "DebtorAccount" : {
        "Name" : "Name"
      },
      "RemittanceInformation" : {
        "RemittanceDescription" : "RemittanceDescription",
        "Reference" : "Reference"
      },
      "EndToEndIdentification" : "EndToEndIdentification",
      "InstructionIdentification" : "InstructionIdentification",
      "CreditorAccount" : {
        "Identification" : { },
        "SchemeName" : { },
        "Name" : "Name"
      },
      "CreditorPostalAddress" : {
        "CountrySubDivision" : { },
        "StreetName" : { },
        "Department" : { },
        "AddressLine" : [ "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine" ],
        "BuildingNumber" : { },
        "TownName" : { },
        "Country" : { },
        "SubDepartment" : { },
        "AddressType" : { },
        "PostCode" : { }
      },
      "InstructedAmount" : {
        "Amount" : { },
        "Currency" : { }
      }
    },
    "ExpectedSettlementDateTime" : "2000-01-23T04:56:07.000+00:00"
  }
}"""),
       List(UserNotLoggedIn, UnknownError),
       ApiTag("Domestic Payments") :: apiTagMockedData :: Nil
     )

     lazy val domesticPaymentsDomesticPaymentIdGet : OBPEndpoint = {
       case "domestic-payments" :: domesticPaymentId :: Nil JsonGet _ => {
         cc =>
           for {
             (Full(u), callContext) <- authenticatedAccess(cc, UserNotLoggedIn)
             } yield {
            (json.parse("""{
  "Meta" : {
    "FirstAvailableDateTime" : { },
    "TotalPages" : 0
  },
  "Links" : {
    "Last" : "http://example.com/aeiou",
    "Prev" : "http://example.com/aeiou",
    "Next" : "http://example.com/aeiou",
    "First" : "http://example.com/aeiou",
    "Self" : "http://example.com/aeiou"
  },
  "Data" : {
    "DomesticPaymentId" : "DomesticPaymentId",
    "Status" : "AcceptedCreditSettlementCompleted",
    "StatusUpdateDateTime" : "2000-01-23T04:56:07.000+00:00",
    "Debtor" : {
      "Name" : "Name"
    },
    "CreationDateTime" : "2000-01-23T04:56:07.000+00:00",
    "ExpectedExecutionDateTime" : "2000-01-23T04:56:07.000+00:00",
    "Refund" : {
      "Account" : {
        "Identification" : { },
        "SchemeName" : { },
        "Name" : "Name"
      }
    },
    "Charges" : [ {
      "Type" : { },
      "Amount" : {
        "Amount" : { },
        "Currency" : { }
      },
      "ChargeBearer" : { }
    }, {
      "Type" : { },
      "Amount" : {
        "Amount" : { },
        "Currency" : { }
      },
      "ChargeBearer" : { }
    } ],
    "ConsentId" : "ConsentId",
    "Initiation" : {
      "SupplementaryData" : { },
      "LocalInstrument" : { },
      "DebtorAccount" : {
        "Name" : "Name"
      },
      "RemittanceInformation" : {
        "RemittanceDescription" : "RemittanceDescription",
        "Reference" : "Reference"
      },
      "EndToEndIdentification" : "EndToEndIdentification",
      "InstructionIdentification" : "InstructionIdentification",
      "CreditorAccount" : {
        "Identification" : { },
        "SchemeName" : { },
        "Name" : "Name"
      },
      "CreditorPostalAddress" : {
        "CountrySubDivision" : { },
        "StreetName" : { },
        "Department" : { },
        "AddressLine" : [ "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine" ],
        "BuildingNumber" : { },
        "TownName" : { },
        "Country" : { },
        "SubDepartment" : { },
        "AddressType" : { },
        "PostCode" : { }
      },
      "InstructedAmount" : {
        "Amount" : { },
        "Currency" : { }
      }
    },
    "ExpectedSettlementDateTime" : "2000-01-23T04:56:07.000+00:00"
  }
}"""), callContext)
           }
         }
       }
            
     resourceDocs += ResourceDoc(
       domesticPaymentsDomesticPaymentIdPaymentDetailsGet, 
       apiVersion, 
       nameOf(domesticPaymentsDomesticPaymentIdPaymentDetailsGet),
       "GET", 
       "/domestic-payments/DOMESTIC_PAYMENT_ID/payment-details", 
       "Get Domestic Payment details by DomesticPaymentId",
       s"""${mockedDataText(true)}
            
            """,
       json.parse(""""""),
       json.parse("""{
  "Meta" : {
    "FirstAvailableDateTime" : { },
    "TotalPages" : 0
  },
  "Links" : {
    "Last" : "http://example.com/aeiou",
    "Prev" : "http://example.com/aeiou",
    "Next" : "http://example.com/aeiou",
    "First" : "http://example.com/aeiou",
    "Self" : "http://example.com/aeiou"
  },
  "Data" : {
    "PaymentStatus" : [ {
      "PaymentTransactionId" : "PaymentTransactionId",
      "Status" : "Accepted",
      "StatusUpdateDateTime" : "2000-01-23T04:56:07.000+00:00",
      "StatusDetail" : {
        "Status" : "Status",
        "LocalInstrument" : { },
        "StatusReason" : "Cancelled",
        "StatusReasonDescription" : "StatusReasonDescription"
      }
    }, {
      "PaymentTransactionId" : "PaymentTransactionId",
      "Status" : "Accepted",
      "StatusUpdateDateTime" : "2000-01-23T04:56:07.000+00:00",
      "StatusDetail" : {
        "Status" : "Status",
        "LocalInstrument" : { },
        "StatusReason" : "Cancelled",
        "StatusReasonDescription" : "StatusReasonDescription"
      }
    } ]
  }
}"""),
       List(UserNotLoggedIn, UnknownError),
       ApiTag("Domestic Payments") :: apiTagMockedData :: Nil
     )

     lazy val domesticPaymentsDomesticPaymentIdPaymentDetailsGet : OBPEndpoint = {
       case "domestic-payments" :: domesticPaymentId:: "payment-details" :: Nil JsonGet _ => {
         cc =>
           for {
             (Full(u), callContext) <- authenticatedAccess(cc, UserNotLoggedIn)
             } yield {
            (json.parse("""{
  "Meta" : {
    "FirstAvailableDateTime" : { },
    "TotalPages" : 0
  },
  "Links" : {
    "Last" : "http://example.com/aeiou",
    "Prev" : "http://example.com/aeiou",
    "Next" : "http://example.com/aeiou",
    "First" : "http://example.com/aeiou",
    "Self" : "http://example.com/aeiou"
  },
  "Data" : {
    "PaymentStatus" : [ {
      "PaymentTransactionId" : "PaymentTransactionId",
      "Status" : "Accepted",
      "StatusUpdateDateTime" : "2000-01-23T04:56:07.000+00:00",
      "StatusDetail" : {
        "Status" : "Status",
        "LocalInstrument" : { },
        "StatusReason" : "Cancelled",
        "StatusReasonDescription" : "StatusReasonDescription"
      }
    }, {
      "PaymentTransactionId" : "PaymentTransactionId",
      "Status" : "Accepted",
      "StatusUpdateDateTime" : "2000-01-23T04:56:07.000+00:00",
      "StatusDetail" : {
        "Status" : "Status",
        "LocalInstrument" : { },
        "StatusReason" : "Cancelled",
        "StatusReasonDescription" : "StatusReasonDescription"
      }
    } ]
  }
}"""), callContext)
           }
         }
       }
            
     resourceDocs += ResourceDoc(
       domesticPaymentsPost, 
       apiVersion, 
       nameOf(domesticPaymentsPost),
       "POST", 
       "/domestic-payments", 
       "Create Domestic Payments",
       s"""${mockedDataText(true)}
            
            """,
       json.parse("""{
  "Risk" : {
    "DeliveryAddress" : {
      "CountrySubDivision" : [ "CountrySubDivision", "CountrySubDivision" ],
      "AddressLine" : [ "AddressLine", "AddressLine" ],
      "Country" : "Country"
    },
    "PaymentContextCode" : "BillPayment",
    "MerchantCategoryCode" : "MerchantCategoryCode",
    "MerchantCustomerIdentification" : "MerchantCustomerIdentification"
  },
  "Data" : {
    "ConsentId" : "ConsentId",
    "Initiation" : {
      "SupplementaryData" : { },
      "LocalInstrument" : { },
      "DebtorAccount" : {
        "Name" : "Name"
      },
      "RemittanceInformation" : {
        "RemittanceDescription" : "RemittanceDescription",
        "Reference" : "Reference"
      },
      "EndToEndIdentification" : "EndToEndIdentification",
      "InstructionIdentification" : "InstructionIdentification",
      "CreditorAccount" : {
        "Identification" : { },
        "SchemeName" : { },
        "Name" : "Name"
      },
      "CreditorPostalAddress" : {
        "CountrySubDivision" : { },
        "StreetName" : { },
        "Department" : { },
        "AddressLine" : [ "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine" ],
        "BuildingNumber" : { },
        "TownName" : { },
        "Country" : { },
        "SubDepartment" : { },
        "AddressType" : { },
        "PostCode" : { }
      },
      "InstructedAmount" : {
        "Amount" : { },
        "Currency" : { }
      }
    }
  }
}"""),
       json.parse("""{
  "Meta" : {
    "FirstAvailableDateTime" : { },
    "TotalPages" : 0
  },
  "Links" : {
    "Last" : "http://example.com/aeiou",
    "Prev" : "http://example.com/aeiou",
    "Next" : "http://example.com/aeiou",
    "First" : "http://example.com/aeiou",
    "Self" : "http://example.com/aeiou"
  },
  "Data" : {
    "DomesticPaymentId" : "DomesticPaymentId",
    "Status" : "AcceptedCreditSettlementCompleted",
    "StatusUpdateDateTime" : "2000-01-23T04:56:07.000+00:00",
    "Debtor" : {
      "Name" : "Name"
    },
    "CreationDateTime" : "2000-01-23T04:56:07.000+00:00",
    "ExpectedExecutionDateTime" : "2000-01-23T04:56:07.000+00:00",
    "Refund" : {
      "Account" : {
        "Identification" : { },
        "SchemeName" : { },
        "Name" : "Name"
      }
    },
    "Charges" : [ {
      "Type" : { },
      "Amount" : {
        "Amount" : { },
        "Currency" : { }
      },
      "ChargeBearer" : { }
    }, {
      "Type" : { },
      "Amount" : {
        "Amount" : { },
        "Currency" : { }
      },
      "ChargeBearer" : { }
    } ],
    "ConsentId" : "ConsentId",
    "Initiation" : {
      "SupplementaryData" : { },
      "LocalInstrument" : { },
      "DebtorAccount" : {
        "Name" : "Name"
      },
      "RemittanceInformation" : {
        "RemittanceDescription" : "RemittanceDescription",
        "Reference" : "Reference"
      },
      "EndToEndIdentification" : "EndToEndIdentification",
      "InstructionIdentification" : "InstructionIdentification",
      "CreditorAccount" : {
        "Identification" : { },
        "SchemeName" : { },
        "Name" : "Name"
      },
      "CreditorPostalAddress" : {
        "CountrySubDivision" : { },
        "StreetName" : { },
        "Department" : { },
        "AddressLine" : [ "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine" ],
        "BuildingNumber" : { },
        "TownName" : { },
        "Country" : { },
        "SubDepartment" : { },
        "AddressType" : { },
        "PostCode" : { }
      },
      "InstructedAmount" : {
        "Amount" : { },
        "Currency" : { }
      }
    },
    "ExpectedSettlementDateTime" : "2000-01-23T04:56:07.000+00:00"
  }
}"""),
       List(UserNotLoggedIn, UnknownError),
       ApiTag("Domestic Payments") :: apiTagMockedData :: Nil
     )

     lazy val domesticPaymentsPost : OBPEndpoint = {
       case "domestic-payments" :: Nil JsonPost _ => {
         cc =>
           for {
             (Full(u), callContext) <- authenticatedAccess(cc, UserNotLoggedIn)
             } yield {
            (json.parse("""{
  "Meta" : {
    "FirstAvailableDateTime" : { },
    "TotalPages" : 0
  },
  "Links" : {
    "Last" : "http://example.com/aeiou",
    "Prev" : "http://example.com/aeiou",
    "Next" : "http://example.com/aeiou",
    "First" : "http://example.com/aeiou",
    "Self" : "http://example.com/aeiou"
  },
  "Data" : {
    "DomesticPaymentId" : "DomesticPaymentId",
    "Status" : "AcceptedCreditSettlementCompleted",
    "StatusUpdateDateTime" : "2000-01-23T04:56:07.000+00:00",
    "Debtor" : {
      "Name" : "Name"
    },
    "CreationDateTime" : "2000-01-23T04:56:07.000+00:00",
    "ExpectedExecutionDateTime" : "2000-01-23T04:56:07.000+00:00",
    "Refund" : {
      "Account" : {
        "Identification" : { },
        "SchemeName" : { },
        "Name" : "Name"
      }
    },
    "Charges" : [ {
      "Type" : { },
      "Amount" : {
        "Amount" : { },
        "Currency" : { }
      },
      "ChargeBearer" : { }
    }, {
      "Type" : { },
      "Amount" : {
        "Amount" : { },
        "Currency" : { }
      },
      "ChargeBearer" : { }
    } ],
    "ConsentId" : "ConsentId",
    "Initiation" : {
      "SupplementaryData" : { },
      "LocalInstrument" : { },
      "DebtorAccount" : {
        "Name" : "Name"
      },
      "RemittanceInformation" : {
        "RemittanceDescription" : "RemittanceDescription",
        "Reference" : "Reference"
      },
      "EndToEndIdentification" : "EndToEndIdentification",
      "InstructionIdentification" : "InstructionIdentification",
      "CreditorAccount" : {
        "Identification" : { },
        "SchemeName" : { },
        "Name" : "Name"
      },
      "CreditorPostalAddress" : {
        "CountrySubDivision" : { },
        "StreetName" : { },
        "Department" : { },
        "AddressLine" : [ "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine", "AddressLine" ],
        "BuildingNumber" : { },
        "TownName" : { },
        "Country" : { },
        "SubDepartment" : { },
        "AddressType" : { },
        "PostCode" : { }
      },
      "InstructedAmount" : {
        "Amount" : { },
        "Currency" : { }
      }
    },
    "ExpectedSettlementDateTime" : "2000-01-23T04:56:07.000+00:00"
  }
}"""), callContext)
           }
         }
       }

}



